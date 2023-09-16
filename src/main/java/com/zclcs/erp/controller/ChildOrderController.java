package com.zclcs.erp.controller;

import com.zclcs.erp.api.bean.ao.ChildOrderAo;
import com.zclcs.erp.api.bean.entity.ChildOrder;
import com.zclcs.erp.api.bean.vo.ChildOrderVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.core.base.BaseRsp;
import com.zclcs.erp.core.bean.ValidatedList;
import com.zclcs.erp.core.constant.Strings;
import com.zclcs.erp.core.strategy.ValidGroups;
import com.zclcs.erp.service.ChildOrderService;
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
 * 子订单
 *
 * @author zclcs
 * @since 2023-09-14 11:36:04.813
 */
@Slf4j
@RestController
@RequestMapping("/childOrder")
@RequiredArgsConstructor
public class ChildOrderController {

    private final ChildOrderService childOrderService;

    /**
     * 子订单查询（分页）
     *
     * @see ChildOrderService#findChildOrderPage(BasePageAo, ChildOrderVo)
     */
    @GetMapping
    public BaseRsp<ChildOrderVo> findChildOrderPage(@Validated BasePageAo basePageAo, @Validated ChildOrderVo childOrderVo) {
        BasePage<ChildOrderVo> page = this.childOrderService.findChildOrderPage(basePageAo, childOrderVo);
        return setTotalRow(page);
    }

    /**
     * 子订单查询（集合）
     * 权限: childOrder:list
     *
     * @see ChildOrderService#findChildOrderList(ChildOrderVo)
     */
    @GetMapping("/list")
    public BaseRsp<List<ChildOrderVo>> findChildOrderList(@Validated ChildOrderVo childOrderVo) {
        List<ChildOrderVo> list = this.childOrderService.findChildOrderList(childOrderVo);
        return RspUtil.data(list);
    }

    /**
     * 子订单查询（单个）
     * 权限: childOrder:one
     *
     * @see ChildOrderService#findChildOrder(ChildOrderVo)
     */
    @GetMapping("/one")
    public BaseRsp<ChildOrderVo> findChildOrder(@Validated ChildOrderVo childOrderVo) {
        ChildOrderVo childOrder = this.childOrderService.findChildOrder(childOrderVo);
        return RspUtil.data(childOrder);
    }

    /**
     * 对账单子订单查询（分页）
     *
     * @see ChildOrderService#findChildOrderList(ChildOrderVo)
     */
    @GetMapping("/byBillId")
    public BaseRsp<ChildOrderVo> findChildOrderListByBillIdPage(@Validated BasePageAo basePageAo, @NotNull(message = "{required}") @RequestParam Long billId) {
        BasePage<ChildOrderVo> page = this.childOrderService.findChildOrderListByBillIdPage(basePageAo, billId);
        return setTotalRow(page);
    }

    /**
     * 新增子订单
     * 权限: childOrder:add
     *
     * @see ChildOrderService#createChildOrder(ChildOrderAo)
     */
    @PostMapping
    public BaseRsp<ChildOrder> addChildOrder(@Validated @RequestBody ChildOrderAo childOrderAo) {
        return RspUtil.data(this.childOrderService.createChildOrder(childOrderAo));
    }

    /**
     * 修改子订单
     * 权限: childOrder:update
     *
     * @see ChildOrderService#updateChildOrder(ChildOrderAo)
     */
    @PutMapping
    public BaseRsp<ChildOrder> updateChildOrder(@Validated({ValidGroups.Crud.Update.class}) @RequestBody ChildOrderAo childOrderAo) {
        return RspUtil.data(this.childOrderService.updateChildOrder(childOrderAo));
    }

    /**
     * 新增或修改子订单
     * 权限: childOrder:createOrUpdate
     *
     * @see ChildOrderService#createOrUpdateChildOrder(ChildOrderAo)
     */
    @PostMapping("/createOrUpdate")
    public BaseRsp<ChildOrder> createOrUpdateChildOrder(@RequestBody @Validated ChildOrderAo childOrderAo) {
        return RspUtil.data(this.childOrderService.createOrUpdateChildOrder(childOrderAo));
    }

    /**
     * 删除子订单
     * 权限: childOrder:delete
     *
     * @param childOrderIds 子订单id集合(,分隔)
     * @see ChildOrderService#deleteChildOrder(List)
     */
    @DeleteMapping("/{childOrderIds}")
    public BaseRsp<String> deleteChildOrder(@NotBlank(message = "{required}") @PathVariable String childOrderIds) {
        List<Long> ids = Arrays.stream(childOrderIds.split(Strings.COMMA)).map(Long::valueOf).collect(Collectors.toList());
        this.childOrderService.deleteChildOrder(ids);
        return RspUtil.message("删除成功");
    }

    /**
     * 批量新增子订单
     * 权限: childOrder:add:batch
     *
     * @see ChildOrderService#createChildOrderBatch(List)
     */
    @PostMapping("/batch")
    public BaseRsp<List<ChildOrder>> createChildOrderBatch(@RequestBody @Validated ValidatedList<ChildOrderAo> childOrderAos) {
        return RspUtil.data(this.childOrderService.createChildOrderBatch(childOrderAos));
    }

    /**
     * 批量修改子订单
     * 权限: childOrder:update:batch
     *
     * @see ChildOrderService#createOrUpdateChildOrderBatch(List)
     */
    @PutMapping("/batch")
    public BaseRsp<List<ChildOrder>> updateChildOrderBatch(@RequestBody @Validated({ValidGroups.Crud.Update.class}) ValidatedList<ChildOrderAo> childOrderAos) {
        return RspUtil.data(this.childOrderService.updateChildOrderBatch(childOrderAos));
    }

    /**
     * 批量新增或修改子订单
     * id为空则新增，不为空则修改
     * 权限: childOrder:createOrUpdate:batch
     *
     * @see ChildOrderService#createOrUpdateChildOrderBatch(List)
     */
    @PostMapping("/createOrUpdate/batch")
    public BaseRsp<List<ChildOrder>> createOrUpdateChildOrderBatch(@RequestBody @Validated ValidatedList<ChildOrderAo> childOrderAos) {
        return RspUtil.data(this.childOrderService.createOrUpdateChildOrderBatch(childOrderAos));
    }

    private BaseRsp<ChildOrderVo> setTotalRow(BasePage<ChildOrderVo> page) {
        Map<String, Object> totalRow = new HashMap<>(1);
        int number = 0;
        int weight = 0;
        BigDecimal amount = new BigDecimal("0");
        for (ChildOrderVo vo : page.getList()) {
            if (vo.getNumber() != null) {
                number = number + vo.getNumber();
            }
            if (vo.getWeight() != null) {
                weight = weight + vo.getWeight();
            }
            if (vo.getAmount() != null) {
                amount = amount.add(vo.getAmount());
            }
        }
        totalRow.put("number", number);
        totalRow.put("weight", weight);
        totalRow.put("amount", amount);
        return RspUtil.page(page, totalRow);
    }
}