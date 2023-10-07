package com.zclcs.erp.runner;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.mybatisflex.core.query.QueryWrapper;
import com.zclcs.erp.api.bean.ao.BillAo;
import com.zclcs.erp.service.BillService;
import com.zclcs.erp.service.OrdersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.mybatisflex.core.query.QueryMethods.max;
import static com.mybatisflex.core.query.QueryMethods.min;
import static com.zclcs.erp.api.bean.entity.table.OrdersTableDef.ORDERS;

/**
 * @author zclcs
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class BillRunner implements CommandLineRunner {

    private final OrdersService ordersService;
    private final BillService billService;

    @Override
    public void run(String... args) {
        String min = ordersService.getOneAs(new QueryWrapper().select(min(ORDERS.DELIVERY_DATE)), String.class);
        String max = ordersService.getOneAs(new QueryWrapper().select(max(ORDERS.DELIVERY_DATE)), String.class);
        DateTime minDate = DateUtil.parse(min, DatePattern.NORM_DATE_PATTERN);
        DateTime maxDate = DateUtil.parse(max, DatePattern.NORM_DATE_PATTERN);
        long betweenMonth = DateUtil.betweenMonth(minDate, maxDate, true);
        DateTime dateTime = DateUtil.beginOfMonth(minDate);
        billService.createBill(BillAo.builder()
                .deliveryDateMonth(dateTime.toString(DatePattern.NORM_MONTH_PATTERN))
                .build());
        for (int i = 1; i < betweenMonth; i++) {
            DateTime offset = dateTime.offset(DateField.MONTH, 1);
            billService.createBill(BillAo.builder()
                    .deliveryDateMonth(offset.toString(DatePattern.NORM_MONTH_PATTERN))
                    .build());
        }

    }
}
