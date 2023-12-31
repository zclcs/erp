package com.zclcs.erp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.If;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.zclcs.erp.api.bean.ao.ChildOrderAo;
import com.zclcs.erp.api.bean.entity.ChildOrder;
import com.zclcs.erp.api.bean.vo.ChildOrderVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.mapper.ChildOrderMapper;
import com.zclcs.erp.service.ChildOrderBillService;
import com.zclcs.erp.service.ChildOrderService;
import com.zclcs.erp.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.zclcs.erp.api.bean.entity.table.ChildOrderBillTableDef.CHILD_ORDER_BILL;
import static com.zclcs.erp.api.bean.entity.table.ChildOrderTableDef.CHILD_ORDER;
import static com.zclcs.erp.api.bean.entity.table.OrdersTableDef.ORDERS;
import static com.zclcs.erp.api.bean.entity.table.ProductTableDef.PRODUCT;

/**
 * 子订单 Service实现
 *
 * @author zclcs
 * @since 2023-09-14 11:36:04.813
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ChildOrderServiceImpl extends ServiceImpl<ChildOrderMapper, ChildOrder> implements ChildOrderService {

    private final ProductService productService;
    private final ChildOrderBillService childOrderBillService;

    @Override
    public BasePage<ChildOrderVo> findChildOrderPage(BasePageAo basePageAo, ChildOrderVo childOrderVo) {
        QueryWrapper queryWrapper = getQueryWrapper(childOrderVo);
        Page<ChildOrderVo> page = this.mapper.paginateAs(basePageAo.getPage(), basePageAo.getLimit(), queryWrapper, ChildOrderVo.class);
        return new BasePage<>(page);
    }

    @Override
    public List<ChildOrderVo> findChildOrderList(ChildOrderVo childOrderVo) {
        QueryWrapper queryWrapper = getQueryWrapper(childOrderVo);
        return this.mapper.selectListByQueryAs(queryWrapper, ChildOrderVo.class);
    }

    @Override
    public ChildOrderVo findChildOrder(ChildOrderVo childOrderVo) {
        QueryWrapper queryWrapper = getQueryWrapper(childOrderVo);
        return this.mapper.selectOneByQueryAs(queryWrapper, ChildOrderVo.class);
    }

    @Override
    public BasePage<ChildOrderVo> findChildOrderListByBillIdPage(BasePageAo basePageAo, Long billId) {
        QueryWrapper queryWrapper = getQueryWrapper(billId);
        Page<ChildOrderVo> page = this.mapper.paginateAs(basePageAo.getPage(), basePageAo.getLimit(), queryWrapper, ChildOrderVo.class);
        return new BasePage<>(page);
    }

    @Override
    public List<ChildOrderVo> findChildOrderListByBillIdList(Long billId) {
        QueryWrapper queryWrapper = getQueryWrapper(billId);
        return this.mapper.selectListByQueryAs(queryWrapper, ChildOrderVo.class);
    }

    @Override
    public Long countChildOrder(ChildOrderVo childOrderVo) {
        QueryWrapper queryWrapper = getQueryWrapper(childOrderVo);
        return this.mapper.selectCountByQuery(queryWrapper);
    }

    private QueryWrapper getQueryWrapper(Long billId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(
                        CHILD_ORDER.ID,
                        CHILD_ORDER.ORDERS_ID,
                        CHILD_ORDER.PRODUCT_ID,
                        PRODUCT.NAME.as("productName"),
                        CHILD_ORDER.SPECIFICATION,
                        CHILD_ORDER.NUMBER,
                        CHILD_ORDER.WEIGHT,
                        CHILD_ORDER.PRICE,
                        CHILD_ORDER.AMOUNT,
                        CHILD_ORDER.REMARK,
                        ORDERS.DELIVERY_DATE.as("delivery_date_original")
                )
                .innerJoin(PRODUCT).on(CHILD_ORDER.PRODUCT_ID.eq(PRODUCT.ID))
                .innerJoin(
                        CHILD_ORDER_BILL
                ).on(CHILD_ORDER.ID.eq(CHILD_ORDER_BILL.CHILD_ORDER_ID))
                .innerJoin(
                        ORDERS
                ).on(CHILD_ORDER.ORDERS_ID.eq(ORDERS.ID))
                .where(CHILD_ORDER_BILL.BILL_ID.eq(billId))
                .orderBy(CHILD_ORDER.ID.desc())
        ;
        return queryWrapper;
    }

    private QueryWrapper getQueryWrapper(ChildOrderVo childOrderVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(
                        CHILD_ORDER.ID,
                        CHILD_ORDER.ORDERS_ID,
                        CHILD_ORDER.PRODUCT_ID,
                        PRODUCT.NAME.as("productName"),
                        CHILD_ORDER.SPECIFICATION,
                        CHILD_ORDER.NUMBER,
                        CHILD_ORDER.WEIGHT,
                        CHILD_ORDER.PRICE,
                        CHILD_ORDER.AMOUNT,
                        CHILD_ORDER.REMARK,
                        ORDERS.DELIVERY_DATE.as("delivery_date_original")
                )
                .innerJoin(PRODUCT).on(CHILD_ORDER.PRODUCT_ID.eq(PRODUCT.ID))
                .innerJoin(
                        ORDERS
                ).on(CHILD_ORDER.ORDERS_ID.eq(ORDERS.ID))
                .where(CHILD_ORDER.ORDERS_ID.eq(childOrderVo.getOrdersId()))
                .and(PRODUCT.NAME.like(childOrderVo.getProductName(), If::hasText))
                .orderBy(CHILD_ORDER.ID.desc())
        ;
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ChildOrder createChildOrder(ChildOrderAo childOrderAo) {
        ChildOrder childOrder = new ChildOrder();
        BeanUtil.copyProperties(childOrderAo, childOrder);
        setChildOrder(childOrder);
        this.save(childOrder);
        return childOrder;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ChildOrder updateChildOrder(ChildOrderAo childOrderAo) {
        ChildOrder childOrder = new ChildOrder();
        BeanUtil.copyProperties(childOrderAo, childOrder);
        setChildOrder(childOrder);
        this.updateById(childOrder);
        return childOrder;
    }

    @Override
    public ChildOrder createOrUpdateChildOrder(ChildOrderAo childOrderAo) {
        ChildOrder childOrder = new ChildOrder();
        BeanUtil.copyProperties(childOrderAo, childOrder);
        this.saveOrUpdate(childOrder);
        return childOrder;
    }

    @Override
    public List<ChildOrder> createChildOrderBatch(List<ChildOrderAo> childOrderAos) {
        List<ChildOrder> childOrderList = new ArrayList<>();
        for (ChildOrderAo childOrderAo : childOrderAos) {
            ChildOrder childOrder = new ChildOrder();
            BeanUtil.copyProperties(childOrderAo, childOrder);
            childOrderList.add(childOrder);
        }
        saveBatch(childOrderList);
        return childOrderList;
    }

    @Override
    public List<ChildOrder> updateChildOrderBatch(List<ChildOrderAo> childOrderAos) {
        List<ChildOrder> childOrderList = new ArrayList<>();
        for (ChildOrderAo childOrderAo : childOrderAos) {
            ChildOrder childOrder = new ChildOrder();
            BeanUtil.copyProperties(childOrderAo, childOrder);
            childOrderList.add(childOrder);
        }
        updateBatch(childOrderList);
        return childOrderList;
    }

    @Override
    public List<ChildOrder> createOrUpdateChildOrderBatch(List<ChildOrderAo> childOrderAos) {
        List<ChildOrder> childOrderList = new ArrayList<>();
        for (ChildOrderAo childOrderAo : childOrderAos) {
            ChildOrder childOrder = new ChildOrder();
            BeanUtil.copyProperties(childOrderAo, childOrder);
            childOrderList.add(childOrder);
        }
        saveOrUpdateBatch(childOrderList);
        return childOrderList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteChildOrder(List<Long> ids) {
        this.removeByIds(ids);
        childOrderBillService.remove(new QueryWrapper().where(CHILD_ORDER_BILL.CHILD_ORDER_ID.in(ids)));
    }

    private void setChildOrder(ChildOrder childOrder) {
        childOrder.setWeight(childOrder.getSpecification() * childOrder.getNumber());
        childOrder.setAmount(new BigDecimal(childOrder.getWeight()).multiply(childOrder.getPrice()));
    }

}
