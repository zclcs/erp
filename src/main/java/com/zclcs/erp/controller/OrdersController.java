package com.zclcs.erp.controller;

import com.zclcs.erp.api.bean.ao.OrdersAo;
import com.zclcs.erp.api.bean.entity.Orders;
import com.zclcs.erp.api.bean.vo.OrdersVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.core.base.BaseRsp;
import com.zclcs.erp.core.bean.ValidatedList;
import com.zclcs.erp.core.constant.Strings;
import com.zclcs.erp.core.strategy.ValidGroups;
import com.zclcs.erp.service.OrdersService;
import com.zclcs.erp.utils.RspUtil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 订单
 *
 * @author zclcs
 * @since 2023-09-14 11:36:32.023
 */
@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    /**
     * 订单查询（分页）
     * 权限: orders:page
     *
     * @see OrdersService#findOrdersPage(BasePageAo, OrdersVo)
     */
    @GetMapping
    public BaseRsp<OrdersVo> findOrdersPage(@Validated BasePageAo basePageAo, @Validated OrdersVo ordersVo) {
        BasePage<OrdersVo> page = this.ordersService.findOrdersPage(basePageAo, ordersVo);
        Map<String, Object> totalRow = new HashMap<>(1);
        BigDecimal totalAmount = new BigDecimal("0");
        for (OrdersVo vo : page.getList()) {
            if (vo.getTotalAmount() != null) {
                totalAmount = totalAmount.add(vo.getTotalAmount());
            }
        }
        totalRow.put("totalAmount", totalAmount);
        return RspUtil.page(page, totalRow);
    }

    /**
     * 订单查询（集合）
     * 权限: orders:list
     *
     * @see OrdersService#findOrdersList(OrdersVo)
     */
    @GetMapping("/list")
    public BaseRsp<List<OrdersVo>> findOrdersList(@Validated OrdersVo ordersVo) {
        List<OrdersVo> list = this.ordersService.findOrdersList(ordersVo);
        return RspUtil.data(list);
    }

    /**
     * 订单查询（单个）
     * 权限: orders:one
     *
     * @see OrdersService#findOrders(OrdersVo)
     */
    @GetMapping("/one")
    public BaseRsp<OrdersVo> findOrders(@Validated OrdersVo ordersVo) {
        OrdersVo orders = this.ordersService.findOrders(ordersVo);
        return RspUtil.data(orders);
    }

    /**
     * 新增订单
     * 权限: orders:add
     *
     * @see OrdersService#createOrders(OrdersAo)
     */
    @PostMapping
    public BaseRsp<Orders> addOrders(@Validated @RequestBody OrdersAo ordersAo) {
        return RspUtil.data(this.ordersService.createOrders(ordersAo));
    }

    /**
     * 修改订单
     * 权限: orders:update
     *
     * @see OrdersService#updateOrders(OrdersAo)
     */
    @PutMapping
    public BaseRsp<Orders> updateOrders(@Validated({ValidGroups.Crud.Update.class}) @RequestBody OrdersAo ordersAo) {
        return RspUtil.data(this.ordersService.updateOrders(ordersAo));
    }

    /**
     * 新增或修改订单
     * 权限: orders:createOrUpdate
     *
     * @see OrdersService#createOrUpdateOrders(OrdersAo)
     */
    @PostMapping("/createOrUpdate")
    public BaseRsp<Orders> createOrUpdateOrders(@RequestBody @Validated OrdersAo ordersAo) {
        return RspUtil.data(this.ordersService.createOrUpdateOrders(ordersAo));
    }

    /**
     * 删除订单
     * 权限: orders:delete
     *
     * @param ordersIds 订单id集合(,分隔)
     * @see OrdersService#deleteOrders(List)
     */
    @DeleteMapping("/{ordersIds}")
    public BaseRsp<String> deleteOrders(@NotBlank(message = "{required}") @PathVariable String ordersIds) {
        List<Long> ids = Arrays.stream(ordersIds.split(Strings.COMMA)).map(Long::valueOf).collect(Collectors.toList());
        this.ordersService.deleteOrders(ids);
        return RspUtil.message("删除成功");
    }

    /**
     * 批量新增订单
     * 权限: orders:add:batch
     *
     * @see OrdersService#createOrdersBatch(List)
     */
    @PostMapping("/batch")
    public BaseRsp<List<Orders>> createOrdersBatch(@RequestBody @Validated ValidatedList<OrdersAo> ordersAos) {
        return RspUtil.data(this.ordersService.createOrdersBatch(ordersAos));
    }

    /**
     * 批量修改订单
     * 权限: orders:update:batch
     *
     * @see OrdersService#createOrUpdateOrdersBatch(List)
     */
    @PutMapping("/batch")
    public BaseRsp<List<Orders>> updateOrdersBatch(@RequestBody @Validated({ValidGroups.Crud.Update.class}) ValidatedList<OrdersAo> ordersAos) {
        return RspUtil.data(this.ordersService.updateOrdersBatch(ordersAos));
    }

    /**
     * 批量新增或修改订单
     * id为空则新增，不为空则修改
     * 权限: orders:createOrUpdate:batch
     *
     * @see OrdersService#createOrUpdateOrdersBatch(List)
     */
    @PostMapping("/createOrUpdate/batch")
    public BaseRsp<List<Orders>> createOrUpdateOrdersBatch(@RequestBody @Validated ValidatedList<OrdersAo> ordersAos) {
        return RspUtil.data(this.ordersService.createOrUpdateOrdersBatch(ordersAos));
    }

    /**
     * 导出送货单
     *
     * @param id id
     */
    @GetMapping("/exportOrders")
    public void exportOrders(@NotNull(message = "{required}") @RequestParam Long id) {
        ordersService.exportOrders(id);
    }

}