package com.zclcs.erp.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.NumberChineseFormatter;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.If;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.zclcs.erp.api.bean.ao.BillAo;
import com.zclcs.erp.api.bean.entity.Bill;
import com.zclcs.erp.api.bean.entity.ChildOrderBill;
import com.zclcs.erp.api.bean.entity.SystemConfig;
import com.zclcs.erp.api.bean.vo.BillVo;
import com.zclcs.erp.api.bean.vo.ChildOrderVo;
import com.zclcs.erp.api.bean.vo.CompanyVo;
import com.zclcs.erp.api.bean.vo.OrdersVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.exception.MyException;
import com.zclcs.erp.mapper.BillMapper;
import com.zclcs.erp.service.*;
import com.zclcs.erp.utils.GenDocUtil;
import com.zclcs.erp.utils.WebUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mybatisflex.core.query.QueryMethods.sum;
import static com.zclcs.erp.api.bean.entity.table.BillTableDef.BILL;
import static com.zclcs.erp.api.bean.entity.table.ChildOrderBillTableDef.CHILD_ORDER_BILL;
import static com.zclcs.erp.api.bean.entity.table.ChildOrderTableDef.CHILD_ORDER;
import static com.zclcs.erp.api.bean.entity.table.CompanyTableDef.COMPANY;

/**
 * 对账单 Service实现
 *
 * @author zclcs
 * @since 2023-09-14 11:36:09.432
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements BillService {

    private final CompanyService companyService;
    private final OrdersService ordersService;
    private final ChildOrderBillService childOrderBillService;
    private final ChildOrderService childOrderService;
    private final SystemConfigService systemConfigService;

    @Override
    public BasePage<BillVo> findBillPage(BasePageAo basePageAo, BillVo billVo) {
        QueryWrapper queryWrapper = getQueryWrapper(billVo);
        Page<BillVo> page = this.mapper.paginateAs(basePageAo.getPage(), basePageAo.getLimit(), queryWrapper, BillVo.class);
        return new BasePage<>(page);
    }

    @Override
    public List<BillVo> findBillList(BillVo billVo) {
        QueryWrapper queryWrapper = getQueryWrapper(billVo);
        return this.mapper.selectListByQueryAs(queryWrapper, BillVo.class);
    }

    @Override
    public BillVo findBill(BillVo billVo) {
        QueryWrapper queryWrapper = getQueryWrapper(billVo);
        return this.mapper.selectOneByQueryAs(queryWrapper, BillVo.class);
    }

    @Override
    public Long countBill(BillVo billVo) {
        QueryWrapper queryWrapper = getQueryWrapper(billVo);
        return this.mapper.selectCountByQuery(queryWrapper);
    }

    private QueryWrapper getQueryWrapper(BillVo billVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(
                        BILL.ID,
                        BILL.COMPANY_ID,
                        COMPANY.NAME.as("companyName"),
                        BILL.DELIVERY_DATE,
                        BILL.NAME,
                        sum(CHILD_ORDER.AMOUNT).as("totalAmount")
                )
                .innerJoin(COMPANY).on(BILL.COMPANY_ID.eq(COMPANY.ID))
                .leftJoin(CHILD_ORDER_BILL).on(CHILD_ORDER_BILL.BILL_ID.eq(BILL.ID))
                .leftJoin(CHILD_ORDER).on(CHILD_ORDER.ID.eq(CHILD_ORDER_BILL.CHILD_ORDER_ID))
                .where(BILL.DELIVERY_DATE.eq(billVo.getDeliveryDateMonth(), If::hasText))
                .and(COMPANY.NAME.like(billVo.getCompanyName(), If::hasText))
                .and(BILL.ID.eq(billVo.getId()))
                .orderBy(BILL.DELIVERY_DATE.desc())
                .groupBy(
                        BILL.ID,
                        BILL.COMPANY_ID,
                        COMPANY.NAME,
                        BILL.DELIVERY_DATE,
                        BILL.NAME
                )
        ;
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createBill(BillAo billAo) {
        String deliveryDateMonth = billAo.getDeliveryDateMonth();
        String deliveryDateMonthChinese = NumberChineseFormatter.format(DateUtil.month(DateUtil.date()) + 1, false, false) + "月份";
        // 先删除
        List<Long> billIds = this.listAs(new QueryWrapper().select(BILL.ID).where(BILL.DELIVERY_DATE.eq(deliveryDateMonth)), Long.class);
        if (CollectionUtil.isNotEmpty(billIds)) {
            this.removeByIds(billIds);
            childOrderBillService.remove(new QueryWrapper().where(CHILD_ORDER_BILL.BILL_ID.in(billIds)));
        }
        // 再新增
        List<CompanyVo> companyList = companyService.findCompanyList(CompanyVo.builder().build());
        List<Bill> billList = new ArrayList<>();
        Map<Long, List<Long>> companyChildOrders = new HashMap<>(companyList.size());
        for (CompanyVo companyVo : companyList) {
            List<OrdersVo> ordersList = ordersService.findOrdersList(OrdersVo.builder()
                    .deliveryDateMonth(deliveryDateMonth)
                    .companyId(companyVo.getId())
                    .build());
            if (CollectionUtils.isEmpty(ordersList)) {
                continue;
            }
            Bill bill = new Bill();
            bill.setName(companyVo.getName() + deliveryDateMonthChinese + "-对账单");
            bill.setDeliveryDate(deliveryDateMonth);
            bill.setCompanyId(companyVo.getId());
            List<Long> childOrderIds = new ArrayList<>();
            for (OrdersVo ordersVo : ordersList) {
                childOrderIds.addAll(ordersVo.getTotalChildOrderId());
            }
            companyChildOrders.put(companyVo.getId(), childOrderIds);
            billList.add(bill);
        }
        this.saveBatch(billList);
        List<ChildOrderBill> childOrderBills = new ArrayList<>();
        for (Bill bill : billList) {
            List<Long> childOrderIds = companyChildOrders.get(bill.getCompanyId());
            for (Long childOrderId : childOrderIds) {
                ChildOrderBill childOrderBill = new ChildOrderBill();
                childOrderBill.setBillId(bill.getId());
                childOrderBill.setChildOrderId(childOrderId);
                childOrderBills.add(childOrderBill);
            }
        }
        childOrderBillService.saveBatch(childOrderBills);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBill(List<Long> ids) {
        this.removeByIds(ids);
    }

    @Override
    public void exportBill(Long id) {
        BillVo bill = this.findBill(BillVo.builder().id(id).build());
        DateTime deliveryDate = DateUtil.parse(bill.getDeliveryDate(), DatePattern.NORM_MONTH_FORMAT);
        SystemConfig one = systemConfigService.getOne(new QueryWrapper().limit(1));
        Map<String, Object> dataMap = new HashMap<>(10);
        dataMap.put("salesman", one.getSalesman());
        dataMap.put("phone", one.getPhone());
        dataMap.put("title", one.getTitle());
        dataMap.put("companyName", bill.getCompanyName());
        dataMap.put("date", DateUtil.date().toString(DatePattern.CHINESE_DATE_PATTERN));
        List<ChildOrderVo> childOrderBillList = childOrderService.findChildOrderListByBillIdList(id);
        BigDecimal smallTotalAmount = new BigDecimal("0");
        for (ChildOrderVo childOrderVo : childOrderBillList) {
            smallTotalAmount = smallTotalAmount.add(childOrderVo.getAmount());
        }
        dataMap.put("smallTotalAmount", smallTotalAmount);
        dataMap.put("bigTotalAmount", Convert.digitToChinese(smallTotalAmount));
        dataMap.put("deliveryDateString", NumberChineseFormatter.format(
                DateUtil.month(deliveryDate) + 1, false, false) + "月份");
        dataMap.put("year", DateUtil.year(deliveryDate) + "年");
        if (CollectionUtil.isEmpty(childOrderBillList)) {
            for (int i = 0; i < 22; i++) {
                ChildOrderVo childOrderVo = new ChildOrderVo();
                childOrderBillList.add(childOrderVo);
            }
        } else {
            int listSize = childOrderBillList.size();
            for (int i = 22; i > listSize; i--) {
                ChildOrderVo childOrderVo = new ChildOrderVo();
                childOrderBillList.add(childOrderVo);
            }
            for (ChildOrderVo childOrderVo : childOrderBillList) {
                if (childOrderVo.getDeliveryDateOriginal() != null) {
                    childOrderVo.setDeliveryDate(childOrderVo.getDeliveryDateOriginal().format(DatePattern.NORM_DATE_FORMATTER));
                }
            }
        }
        dataMap.put("billList", childOrderBillList);
        try {
            File file = GenDocUtil.genDoc(this.getClass(), "bill.ftl", dataMap);
            WebUtil.download(file, bill.getName() + ".doc", true);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new MyException("文件生成异常");
        }
    }

}
