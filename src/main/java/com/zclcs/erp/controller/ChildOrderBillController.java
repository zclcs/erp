package com.zclcs.erp.controller;

import com.zclcs.erp.api.bean.ao.ChildOrderBillAo;
import com.zclcs.erp.api.bean.entity.ChildOrderBill;
import com.zclcs.erp.api.bean.vo.ChildOrderBillVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.core.base.BaseRsp;
import com.zclcs.erp.core.bean.ValidatedList;
import com.zclcs.erp.core.constant.Strings;
import com.zclcs.erp.core.strategy.ValidGroups;
import com.zclcs.erp.service.ChildOrderBillService;
import com.zclcs.erp.utils.RspUtil;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对账单和子订单关联
 *
 * @author zclcs
 * @since 2023-09-14 11:36:41.197
 */
@Slf4j
@RestController
@RequestMapping("/childOrderBill")
@RequiredArgsConstructor
public class ChildOrderBillController {

    private final ChildOrderBillService childOrderBillService;

    /**
     * 对账单和子订单关联查询（分页）
     * 权限: childOrderBill:page
     *
     * @see ChildOrderBillService#findChildOrderBillPage(BasePageAo, ChildOrderBillVo)
     */
    @GetMapping
    public BaseRsp<BasePage<ChildOrderBillVo>> findChildOrderBillPage(@Validated BasePageAo basePageAo, @Validated ChildOrderBillVo childOrderBillVo) {
        BasePage<ChildOrderBillVo> page = this.childOrderBillService.findChildOrderBillPage(basePageAo, childOrderBillVo);
        return RspUtil.data(page);
    }

    /**
     * 对账单和子订单关联查询（集合）
     * 权限: childOrderBill:list
     *
     * @see ChildOrderBillService#findChildOrderBillList(ChildOrderBillVo)
     */
    @GetMapping("/list")
    public BaseRsp<List<ChildOrderBillVo>> findChildOrderBillList(@Validated ChildOrderBillVo childOrderBillVo) {
        List<ChildOrderBillVo> list = this.childOrderBillService.findChildOrderBillList(childOrderBillVo);
        return RspUtil.data(list);
    }

    /**
     * 对账单和子订单关联查询（单个）
     * 权限: childOrderBill:one
     *
     * @see ChildOrderBillService#findChildOrderBill(ChildOrderBillVo)
     */
    @GetMapping("/one")
    public BaseRsp<ChildOrderBillVo> findChildOrderBill(@Validated ChildOrderBillVo childOrderBillVo) {
        ChildOrderBillVo childOrderBill = this.childOrderBillService.findChildOrderBill(childOrderBillVo);
        return RspUtil.data(childOrderBill);
    }

    /**
     * 新增对账单和子订单关联
     * 权限: childOrderBill:add
     *
     * @see ChildOrderBillService#createChildOrderBill(ChildOrderBillAo)
     */
    @PostMapping
    public BaseRsp<ChildOrderBill> addChildOrderBill(@Validated @RequestBody ChildOrderBillAo childOrderBillAo) {
        return RspUtil.data(this.childOrderBillService.createChildOrderBill(childOrderBillAo));
    }

    /**
     * 修改对账单和子订单关联
     * 权限: childOrderBill:update
     *
     * @see ChildOrderBillService#updateChildOrderBill(ChildOrderBillAo)
     */
    @PutMapping
    public BaseRsp<ChildOrderBill> updateChildOrderBill(@Validated({ValidGroups.Crud.Update.class}) @RequestBody ChildOrderBillAo childOrderBillAo) {
        return RspUtil.data(this.childOrderBillService.updateChildOrderBill(childOrderBillAo));
    }

    /**
     * 新增或修改对账单和子订单关联
     * 权限: childOrderBill:createOrUpdate
     *
     * @see ChildOrderBillService#createOrUpdateChildOrderBill(ChildOrderBillAo)
     */
    @PostMapping("/createOrUpdate")
    public BaseRsp<ChildOrderBill> createOrUpdateChildOrderBill(@RequestBody @Validated ChildOrderBillAo childOrderBillAo) {
        return RspUtil.data(this.childOrderBillService.createOrUpdateChildOrderBill(childOrderBillAo));
    }

    /**
     * 删除对账单和子订单关联
     * 权限: childOrderBill:delete
     *
     * @param childOrderBillIds 对账单和子订单关联id集合(,分隔)
     * @see ChildOrderBillService#deleteChildOrderBill(List)
     */
    @DeleteMapping("/{childOrderBillIds}")
    public BaseRsp<String> deleteChildOrderBill(@NotBlank(message = "{required}") @PathVariable String childOrderBillIds) {
        List<Long> ids = Arrays.stream(childOrderBillIds.split(Strings.COMMA)).map(Long::valueOf).collect(Collectors.toList());
        this.childOrderBillService.deleteChildOrderBill(ids);
        return RspUtil.message("删除成功");
    }

    /**
     * 批量新增对账单和子订单关联
     * 权限: childOrderBill:add:batch
     *
     * @see ChildOrderBillService#createChildOrderBillBatch(List)
     */
    @PostMapping("/batch")
    public BaseRsp<List<ChildOrderBill>> createChildOrderBillBatch(@RequestBody @Validated ValidatedList<ChildOrderBillAo> childOrderBillAos) {
        return RspUtil.data(this.childOrderBillService.createChildOrderBillBatch(childOrderBillAos));
    }

    /**
     * 批量修改对账单和子订单关联
     * 权限: childOrderBill:update:batch
     *
     * @see ChildOrderBillService#createOrUpdateChildOrderBillBatch(List)
     */
    @PutMapping("/batch")
    public BaseRsp<List<ChildOrderBill>> updateChildOrderBillBatch(@RequestBody @Validated({ValidGroups.Crud.Update.class}) ValidatedList<ChildOrderBillAo> childOrderBillAos) {
        return RspUtil.data(this.childOrderBillService.updateChildOrderBillBatch(childOrderBillAos));
    }

    /**
     * 批量新增或修改对账单和子订单关联
     * id为空则新增，不为空则修改
     * 权限: childOrderBill:createOrUpdate:batch
     *
     * @see ChildOrderBillService#createOrUpdateChildOrderBillBatch(List)
     */
    @PostMapping("/createOrUpdate/batch")
    public BaseRsp<List<ChildOrderBill>> createOrUpdateChildOrderBillBatch(@RequestBody @Validated ValidatedList<ChildOrderBillAo> childOrderBillAos) {
        return RspUtil.data(this.childOrderBillService.createOrUpdateChildOrderBillBatch(childOrderBillAos));
    }

}