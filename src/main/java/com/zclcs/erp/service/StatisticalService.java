package com.zclcs.erp.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.query.QueryWrapper;
import com.zclcs.erp.api.bean.vo.DateCountVo;
import com.zclcs.erp.api.bean.vo.MaxCountVo;
import com.zclcs.erp.api.bean.vo.ProfitCountVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import static com.mybatisflex.core.query.QueryMethods.max;
import static com.mybatisflex.core.query.QueryMethods.sum;
import static com.zclcs.erp.api.bean.entity.table.ChildOrderTableDef.CHILD_ORDER;
import static com.zclcs.erp.api.bean.entity.table.CompanyTableDef.COMPANY;
import static com.zclcs.erp.api.bean.entity.table.OrdersTableDef.ORDERS;
import static com.zclcs.erp.api.bean.entity.table.ProductTableDef.PRODUCT;
import static com.zclcs.erp.api.bean.entity.table.PurchaseTableDef.PURCHASE;

/**
 * @author zclcs
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticalService {

    private final ChildOrderService childOrderService;
    private final PurchaseService purchaseService;

    public List<MaxCountVo> maxCount(String type, Long companyId, String startDate, String endDate, Integer limit) {
        DateTime date = DateUtil.date();
        String startDateElse = Optional.ofNullable(startDate).filter(StrUtil::isNotBlank)
                .orElse(DateUtil.beginOfMonth(date).toString(DatePattern.NORM_DATE_PATTERN));
        String endDateElse = Optional.ofNullable(endDate).filter(StrUtil::isNotBlank)
                .orElse(date.toString(DatePattern.NORM_DATE_PATTERN));
        Integer limitElse = Optional.ofNullable(limit).orElse(10);
        List<MaxCountVo> vos = childOrderService.listAs(invokeQueryWrapper(type, companyId, startDateElse, endDateElse, limitElse), MaxCountVo.class);
        if (CollectionUtil.isEmpty(vos)) {
            vos.add(new MaxCountVo());
        }
        return vos;
    }

    public List<ProfitCountVo> profitCount(String type, String startDate, String endDate) {
        DateTime date = DateUtil.date();
        String startDateElse = Optional.ofNullable(startDate).filter(StrUtil::isNotBlank)
                .orElse(DateUtil.beginOfYear(date).toString(DatePattern.NORM_DATE_PATTERN));
        String endDateElse = Optional.ofNullable(endDate).filter(StrUtil::isNotBlank)
                .orElse(DateUtil.endOfYear(date).toString(DatePattern.NORM_DATE_PATTERN));
        List<ProfitCountVo> profitCountVos = new ArrayList<>();
        Map<DateTime, DateTime> dateTimeDateTimeMap = invokeDate(type, startDateElse, endDateElse);
        QueryWrapper childOrderQueryWrapper = new QueryWrapper();
        childOrderQueryWrapper.select(
                        ORDERS.DELIVERY_DATE.as("date"),
                        sum(CHILD_ORDER.AMOUNT).as("total_amount")
                ).innerJoin(ORDERS).on(CHILD_ORDER.ORDERS_ID.eq(ORDERS.ID))
                .where(ORDERS.DELIVERY_DATE.between(startDate, endDate))
                .groupBy(ORDERS.DELIVERY_DATE)
        ;
        List<DateCountVo> childOrderDateCountVos = childOrderService.listAs(childOrderQueryWrapper, DateCountVo.class);

        QueryWrapper purchaseQueryWrapper = new QueryWrapper();
        purchaseQueryWrapper.select(
                        PURCHASE.PURCHASE_DATE.as("date"),
                        sum(PURCHASE.PURCHASE_AMOUNT).as("total_amount")
                )
                .where(PURCHASE.PURCHASE_DATE.between(startDate, endDate))
                .groupBy(PURCHASE.PURCHASE_DATE)
        ;
        List<DateCountVo> purchaseDateCountVos = purchaseService.listAs(purchaseQueryWrapper, DateCountVo.class);

        for (Map.Entry<DateTime, DateTime> dateTimeDateTimeEntry : dateTimeDateTimeMap.entrySet()) {
            ProfitCountVo profitCountVo = new ProfitCountVo();
            BigDecimal restockAmount = profitCountVo.getRestockAmount();
            BigDecimal deliverGoodsAmount = profitCountVo.getDeliverGoodsAmount();
            BigDecimal profitAmount = profitCountVo.getProfitAmount();
            DateTime start = dateTimeDateTimeEntry.getKey();
            DateTime end = dateTimeDateTimeEntry.getValue();
            for (DateCountVo childOrderDate : childOrderDateCountVos) {
                boolean in = DateUtil.isIn(childOrderDate.getDate(), start, end);
                if (in) {
                    deliverGoodsAmount = deliverGoodsAmount.add(childOrderDate.getTotalAmount());
                }
            }
            for (DateCountVo purchaseDateCountVo : purchaseDateCountVos) {
                boolean in = DateUtil.isIn(purchaseDateCountVo.getDate(), start, end);
                if (in) {
                    restockAmount = restockAmount.add(purchaseDateCountVo.getTotalAmount());
                }
            }
            profitAmount = deliverGoodsAmount.subtract(restockAmount);
            profitCountVo.setDate("1".equals(type) ? start.toString(DatePattern.NORM_YEAR_PATTERN) : start.toString(DatePattern.NORM_MONTH_PATTERN));
            profitCountVo.setRestockAmount(restockAmount);
            profitCountVo.setDeliverGoodsAmount(deliverGoodsAmount);
            profitCountVo.setProfitAmount(profitAmount);
            profitCountVos.add(profitCountVo);
        }
        return profitCountVos;
    }

    private QueryWrapper invokeQueryWrapper(String type, Long companyId, String startDate, String endDate, Integer limit) {
        QueryWrapper queryWrapper = new QueryWrapper();
        switch (type) {
            case "1":
                queryWrapper.select(
                                CHILD_ORDER.PRODUCT_ID.as("id"),
                                PRODUCT.NAME.as("label"),
                                max(CHILD_ORDER.PRICE).as("max_value")
                        )
                        .innerJoin(PRODUCT).on(CHILD_ORDER.PRODUCT_ID.eq(PRODUCT.ID))
                        .innerJoin(ORDERS).on(CHILD_ORDER.ORDERS_ID.eq(ORDERS.ID))
                        .where(ORDERS.DELIVERY_DATE.between(startDate, endDate))
                        .and(ORDERS.COMPANY_ID.eq(companyId))
                        .groupBy("id", "label")
                        .orderBy("max_value", false)
                        .limit(limit)
                ;
                break;
            case "2":
                queryWrapper.select(
                                CHILD_ORDER.PRODUCT_ID.as("id"),
                                PRODUCT.NAME.as("label"),
                                max(CHILD_ORDER.WEIGHT).as("max_value")
                        )
                        .innerJoin(PRODUCT).on(CHILD_ORDER.PRODUCT_ID.eq(PRODUCT.ID))
                        .innerJoin(ORDERS).on(CHILD_ORDER.ORDERS_ID.eq(ORDERS.ID))
                        .where(ORDERS.DELIVERY_DATE.between(startDate, endDate))
                        .and(ORDERS.COMPANY_ID.eq(companyId))
                        .groupBy("id", "label")
                        .orderBy("max_value", false)
                        .limit(limit)
                ;
                break;
            case "3":
                queryWrapper.select(
                                CHILD_ORDER.PRODUCT_ID.as("id"),
                                PRODUCT.NAME.as("label"),
                                max(CHILD_ORDER.AMOUNT).as("max_value")
                        )
                        .innerJoin(PRODUCT).on(CHILD_ORDER.PRODUCT_ID.eq(PRODUCT.ID))
                        .innerJoin(ORDERS).on(CHILD_ORDER.ORDERS_ID.eq(ORDERS.ID))
                        .where(ORDERS.DELIVERY_DATE.between(startDate, endDate))
                        .and(ORDERS.COMPANY_ID.eq(companyId))
                        .groupBy("id", "label")
                        .orderBy("max_value", false)
                        .limit(limit)
                ;
                break;
            case "4":
                queryWrapper.select(
                                ORDERS.COMPANY_ID.as("id"),
                                COMPANY.NAME.as("label"),
                                max(CHILD_ORDER.AMOUNT).as("max_value")
                        )
                        .innerJoin(COMPANY).on(ORDERS.COMPANY_ID.eq(COMPANY.ID))
                        .innerJoin(ORDERS).on(CHILD_ORDER.ORDERS_ID.eq(ORDERS.ID))
                        .where(ORDERS.DELIVERY_DATE.between(startDate, endDate))
                        .groupBy(ORDERS.COMPANY_ID, COMPANY.NAME)
                        .and(ORDERS.COMPANY_ID.eq(companyId))
                        .orderBy("max_value", false)
                        .limit(limit)
                ;
                break;
            default:
                break;
        }
        return queryWrapper;
    }

    private Map<DateTime, DateTime> invokeDate(String type, String startDate, String endDate) {
        DateTime startDateParse = DateUtil.parse(startDate, DatePattern.NORM_DATE_PATTERN);
        DateTime endDateParse = DateUtil.parse(endDate, DatePattern.NORM_DATE_PATTERN);
        Map<DateTime, DateTime> dateGroups = new TreeMap<>();
        if ("1".equals(type)) {
            long betweenYear = DateUtil.betweenYear(startDateParse, endDateParse, true);
            dateGroups.put(DateUtil.beginOfYear(startDateParse), DateUtil.endOfYear(startDateParse));
            for (int i = 0; i < betweenYear; i++) {
                startDateParse.offset(DateField.YEAR, 1);
                dateGroups.put(DateUtil.beginOfYear(startDateParse), DateUtil.endOfYear(startDateParse));
            }
        } else {
            long betweenMonth = DateUtil.betweenMonth(startDateParse, endDateParse, true);
            dateGroups.put(DateUtil.beginOfMonth(startDateParse), DateUtil.endOfMonth(startDateParse));
            for (int i = 0; i < betweenMonth; i++) {
                startDateParse.offset(DateField.MONTH, 1);
                dateGroups.put(DateUtil.beginOfMonth(startDateParse), DateUtil.endOfMonth(startDateParse));
            }
        }
        return dateGroups;
    }

}
