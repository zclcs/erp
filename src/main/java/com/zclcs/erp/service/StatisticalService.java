package com.zclcs.erp.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.mybatisflex.core.query.QueryWrapper;
import com.zclcs.erp.api.bean.vo.MaxAmountByCompanyVo;
import com.zclcs.erp.api.bean.vo.MaxAmountByProductVo;
import com.zclcs.erp.api.bean.vo.MaxPriceByProductVo;
import com.zclcs.erp.api.bean.vo.MaxWeightByProductVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.mybatisflex.core.query.QueryMethods.max;
import static com.zclcs.erp.api.bean.entity.table.ChildOrderTableDef.CHILD_ORDER;
import static com.zclcs.erp.api.bean.entity.table.OrdersTableDef.ORDERS;

/**
 * @author zclcs
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticalService {

    private final ChildOrderService childOrderService;

    public List<MaxPriceByProductVo> maxPriceByProduct(Integer limit) {
        Integer limitElse = Optional.ofNullable(limit).orElse(10);
        QueryWrapper queryWrapper = new QueryWrapper();
        DateTime date = DateUtil.date();
        queryWrapper.select(
                        CHILD_ORDER.PRODUCT_ID,
                        CHILD_ORDER.PRODUCT_NAME,
                        max(CHILD_ORDER.PRICE).as("price")
                ).innerJoin(ORDERS).on(CHILD_ORDER.ORDERS_ID.eq(ORDERS.ID))
//                .where(ORDERS.DELIVERY_DATE.between(DateUtil.beginOfMonth(date).toString(DatePattern.NORM_DATE_PATTERN),
//                        DateUtil.endOfMonth(date).toString(DatePattern.NORM_DATE_PATTERN)))
                .groupBy(CHILD_ORDER.PRODUCT_ID, CHILD_ORDER.PRODUCT_NAME)
                .orderBy("price", false)
                .limit(limitElse)
        ;
        List<MaxPriceByProductVo> vos = childOrderService.listAs(queryWrapper, MaxPriceByProductVo.class);
        return vos;
    }

    public List<MaxWeightByProductVo> maxWeightByProduct(Integer limit) {
        Integer limitElse = Optional.ofNullable(limit).orElse(10);
        QueryWrapper queryWrapper = new QueryWrapper();
        DateTime date = DateUtil.date();
        queryWrapper.select(
                        CHILD_ORDER.PRODUCT_ID,
                        CHILD_ORDER.PRODUCT_NAME,
                        max(CHILD_ORDER.WEIGHT).as("weight")
                ).innerJoin(ORDERS).on(CHILD_ORDER.ORDERS_ID.eq(ORDERS.ID))
//                .where(ORDERS.DELIVERY_DATE.between(DateUtil.beginOfMonth(date).toString(DatePattern.NORM_DATE_PATTERN),
//                        DateUtil.endOfMonth(date).toString(DatePattern.NORM_DATE_PATTERN)))
                .groupBy(CHILD_ORDER.PRODUCT_ID, CHILD_ORDER.PRODUCT_NAME)
                .orderBy("weight", false)
                .limit(limitElse)
        ;
        List<MaxWeightByProductVo> vos = childOrderService.listAs(queryWrapper, MaxWeightByProductVo.class);
        return vos;
    }

    public List<MaxAmountByProductVo> maxAmountByProduct(Integer limit) {
        Integer limitElse = Optional.ofNullable(limit).orElse(10);
        QueryWrapper queryWrapper = new QueryWrapper();
        DateTime date = DateUtil.date();
        queryWrapper.select(
                        CHILD_ORDER.PRODUCT_ID,
                        CHILD_ORDER.PRODUCT_NAME,
                        max(CHILD_ORDER.AMOUNT).as("amount")
                ).innerJoin(ORDERS).on(CHILD_ORDER.ORDERS_ID.eq(ORDERS.ID))
//                .where(ORDERS.DELIVERY_DATE.between(DateUtil.beginOfMonth(date).toString(DatePattern.NORM_DATE_PATTERN),
//                        DateUtil.endOfMonth(date).toString(DatePattern.NORM_DATE_PATTERN)))
                .groupBy(CHILD_ORDER.PRODUCT_ID, CHILD_ORDER.PRODUCT_NAME)
                .orderBy("amount", false)
                .limit(limitElse)
        ;
        List<MaxAmountByProductVo> vos = childOrderService.listAs(queryWrapper, MaxAmountByProductVo.class);
        return vos;
    }

    public List<MaxAmountByCompanyVo> maxAmountByCompany(Integer limit) {
        Integer limitElse = Optional.ofNullable(limit).orElse(10);
        QueryWrapper queryWrapper = new QueryWrapper();
        DateTime date = DateUtil.date();
        queryWrapper.select(
                        ORDERS.COMPANY_ID,
                        ORDERS.COMPANY_NAME,
                        max(CHILD_ORDER.AMOUNT).as("amount")
                ).innerJoin(ORDERS).on(CHILD_ORDER.ORDERS_ID.eq(ORDERS.ID))
//                .where(ORDERS.DELIVERY_DATE.between(DateUtil.beginOfMonth(date).toString(DatePattern.NORM_DATE_PATTERN),
//                        DateUtil.endOfMonth(date).toString(DatePattern.NORM_DATE_PATTERN)))
                .groupBy(
                        ORDERS.COMPANY_ID,
                        ORDERS.COMPANY_NAME
                )
                .orderBy("amount", false)
                .limit(limitElse)
        ;
        List<MaxAmountByCompanyVo> vos = childOrderService.listAs(queryWrapper, MaxAmountByCompanyVo.class);
        return vos;
    }


}
