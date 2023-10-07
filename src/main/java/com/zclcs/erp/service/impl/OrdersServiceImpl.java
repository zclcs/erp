package com.zclcs.erp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.If;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.zclcs.erp.api.bean.ao.OrdersAo;
import com.zclcs.erp.api.bean.entity.Orders;
import com.zclcs.erp.api.bean.entity.SystemConfig;
import com.zclcs.erp.api.bean.vo.ChildOrderVo;
import com.zclcs.erp.api.bean.vo.OrdersVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.exception.MyException;
import com.zclcs.erp.mapper.OrdersMapper;
import com.zclcs.erp.service.*;
import com.zclcs.erp.utils.GenDocUtil;
import com.zclcs.erp.utils.WebUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mybatisflex.core.query.QueryMethods.groupConcat;
import static com.mybatisflex.core.query.QueryMethods.sum;
import static com.zclcs.erp.api.bean.entity.table.ChildOrderBillTableDef.CHILD_ORDER_BILL;
import static com.zclcs.erp.api.bean.entity.table.ChildOrderTableDef.CHILD_ORDER;
import static com.zclcs.erp.api.bean.entity.table.CompanyTableDef.COMPANY;
import static com.zclcs.erp.api.bean.entity.table.OrdersTableDef.ORDERS;

/**
 * 订单 Service实现
 *
 * @author zclcs
 * @since 2023-09-14 11:36:32.023
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    private final SystemConfigService systemConfigService;
    private final ChildOrderService childOrderService;
    private final CompanyService companyService;
    private final ChildOrderBillService childOrderBillService;

    @Override
    public BasePage<OrdersVo> findOrdersPage(BasePageAo basePageAo, OrdersVo ordersVo) {
        QueryWrapper queryWrapper = getQueryWrapper(ordersVo);
        Page<OrdersVo> page = this.mapper.paginateAs(basePageAo.getPage(), basePageAo.getLimit(), queryWrapper, OrdersVo.class);
        return new BasePage<>(page);
    }

    @Override
    public List<OrdersVo> findOrdersList(OrdersVo ordersVo) {
        QueryWrapper queryWrapper = getQueryWrapper(ordersVo);
        return this.mapper.selectListByQueryAs(queryWrapper, OrdersVo.class);
    }

    @Override
    public OrdersVo findOrders(OrdersVo ordersVo) {
        QueryWrapper queryWrapper = getQueryWrapper(ordersVo);
        return this.mapper.selectOneByQueryAs(queryWrapper, OrdersVo.class);
    }

    @Override
    public Long countOrders(OrdersVo ordersVo) {
        QueryWrapper queryWrapper = getQueryWrapper(ordersVo);
        return this.mapper.selectCountByQuery(queryWrapper);
    }

    private QueryWrapper getQueryWrapper(OrdersVo ordersVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(
                        ORDERS.ID,
                        ORDERS.COMPANY_ID,
                        COMPANY.NAME.as("companyName"),
                        ORDERS.DELIVERY_DATE,
                        sum(CHILD_ORDER.AMOUNT).as("totalAmount"),
                        groupConcat(CHILD_ORDER.ID).as("totalChildOrderId")
                )
                .innerJoin(COMPANY).on(ORDERS.COMPANY_ID.eq(COMPANY.ID))
                .leftJoin(CHILD_ORDER).on(ORDERS.ID.eq(CHILD_ORDER.ORDERS_ID))
                .where(COMPANY.NAME.like(ordersVo.getCompanyName(), If::hasText))
                .and(ORDERS.COMPANY_ID.eq(ordersVo.getCompanyId()))
                .and(ORDERS.ID.eq(ordersVo.getId()))
                .orderBy(ORDERS.DELIVERY_DATE.desc())
                .groupBy(
                        ORDERS.ID,
                        ORDERS.COMPANY_ID,
                        COMPANY.NAME,
                        ORDERS.DELIVERY_DATE
                )
        ;
        String deliveryDateMonth = ordersVo.getDeliveryDateMonth();
        if (StrUtil.isNotBlank(deliveryDateMonth)) {
            DateTime dataMonth = DateUtil.parse(deliveryDateMonth, DatePattern.NORM_MONTH_FORMAT);
            queryWrapper.and(ORDERS.DELIVERY_DATE.between(DateUtil.beginOfMonth(dataMonth).toString(DatePattern.NORM_DATE_PATTERN), DateUtil.endOfMonth(dataMonth).toString(DatePattern.NORM_DATE_PATTERN)));
        }
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Orders createOrders(OrdersAo ordersAo) {
        Orders orders = new Orders();
        BeanUtil.copyProperties(ordersAo, orders);
        this.save(orders);
        return orders;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Orders updateOrders(OrdersAo ordersAo) {
        Orders orders = new Orders();
        BeanUtil.copyProperties(ordersAo, orders);
        this.updateById(orders);
        return orders;
    }

    @Override
    public Orders createOrUpdateOrders(OrdersAo ordersAo) {
        Orders orders = new Orders();
        BeanUtil.copyProperties(ordersAo, orders);
        this.saveOrUpdate(orders);
        return orders;
    }

    @Override
    public List<Orders> createOrdersBatch(List<OrdersAo> ordersAos) {
        List<Orders> ordersList = new ArrayList<>();
        for (OrdersAo ordersAo : ordersAos) {
            Orders orders = new Orders();
            BeanUtil.copyProperties(ordersAo, orders);
            ordersList.add(orders);
        }
        saveBatch(ordersList);
        return ordersList;
    }

    @Override
    public List<Orders> updateOrdersBatch(List<OrdersAo> ordersAos) {
        List<Orders> ordersList = new ArrayList<>();
        for (OrdersAo ordersAo : ordersAos) {
            Orders orders = new Orders();
            BeanUtil.copyProperties(ordersAo, orders);
            ordersList.add(orders);
        }
        updateBatch(ordersList);
        return ordersList;
    }

    @Override
    public List<Orders> createOrUpdateOrdersBatch(List<OrdersAo> ordersAos) {
        List<Orders> ordersList = new ArrayList<>();
        for (OrdersAo ordersAo : ordersAos) {
            Orders orders = new Orders();
            BeanUtil.copyProperties(ordersAo, orders);
            ordersList.add(orders);
        }
        saveOrUpdateBatch(ordersList);
        return ordersList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOrders(List<Long> ids) {
        this.removeByIds(ids);
        List<Long> childOrderIds = childOrderService.listAs(new QueryWrapper().select(CHILD_ORDER.ID).where(CHILD_ORDER.ORDERS_ID.in(ids)), Long.class);
        childOrderService.remove(new QueryWrapper().where(CHILD_ORDER.ORDERS_ID.in(ids)));
        if (CollectionUtil.isNotEmpty(childOrderIds)) {
            childOrderBillService.remove(new QueryWrapper().where(CHILD_ORDER_BILL.CHILD_ORDER_ID.in(childOrderIds)));
        }
    }

    @Override
    public void exportOrders(Long id) {
        OrdersVo orders = findOrders(OrdersVo.builder().id(id).build());
        SystemConfig one = systemConfigService.getOne(new QueryWrapper().limit(1));
        Map<String, Object> dataMap = new HashMap<>(10);
        dataMap.put("salesman", one.getSalesman());
        dataMap.put("phone", one.getPhone());
        dataMap.put("title", one.getTitle());
        dataMap.put("companyName", orders.getCompanyName());
        dataMap.put("deliveryDate", orders.getDeliveryDate().format(DatePattern.NORM_DATE_FORMATTER));
        BigDecimal totalAmount = orders.getTotalAmount();
        dataMap.put("smallTotalAmount", totalAmount);
        dataMap.put("bigTotalAmount", Convert.digitToChinese(totalAmount));
        List<ChildOrderVo> childOrderList = childOrderService.findChildOrderList(ChildOrderVo.builder().ordersId(orders.getId()).build());
        if (CollectionUtil.isEmpty(childOrderList)) {
            for (int i = 0; i < 6; i++) {
                ChildOrderVo childOrderVo = new ChildOrderVo();
                childOrderList.add(childOrderVo);
            }
        } else {
            int listSize = childOrderList.size();
            for (int i = 6; i > listSize; i--) {
                ChildOrderVo childOrderVo = new ChildOrderVo();
                childOrderList.add(childOrderVo);
            }
        }
        dataMap.put("ordersList", childOrderList);
        try {
            File file = GenDocUtil.genDoc(this.getClass(), "order.ftl", dataMap);
            WebUtil.download(file, orders.getCompanyName() + "-" + orders.getDeliveryDate().format(DatePattern.NORM_DATE_FORMATTER) + "-" + "送货单.doc", true);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new MyException("文件生成异常");
        }
    }

}
