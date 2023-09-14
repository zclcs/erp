package com.zclcs.erp.controller;

import com.zclcs.erp.api.bean.ao.BillAo;
import com.zclcs.erp.api.bean.entity.Bill;
import com.zclcs.erp.api.bean.vo.BillVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.core.base.BaseRsp;
import com.zclcs.erp.core.bean.ValidatedList;
import com.zclcs.erp.core.constant.Strings;
import com.zclcs.erp.core.strategy.ValidGroups;
import com.zclcs.erp.service.BillService;
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
 * 对账单
 *
 * @author zclcs
 * @since 2023-09-14 11:36:09.432
 */
@Slf4j
@RestController
@RequestMapping("/bill")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    /**
     * 对账单查询（分页）
     * 权限: bill:page
     *
     * @see BillService#findBillPage(BasePageAo, BillVo)
     */
    @GetMapping
    public BaseRsp<BasePage<BillVo>> findBillPage(@Validated BasePageAo basePageAo, @Validated BillVo billVo) {
        BasePage<BillVo> page = this.billService.findBillPage(basePageAo, billVo);
        return RspUtil.data(page);
    }

    /**
     * 对账单查询（集合）
     * 权限: bill:list
     *
     * @see BillService#findBillList(BillVo)
     */
    @GetMapping("/list")
    public BaseRsp<List<BillVo>> findBillList(@Validated BillVo billVo) {
        List<BillVo> list = this.billService.findBillList(billVo);
        return RspUtil.data(list);
    }

    /**
     * 对账单查询（单个）
     * 权限: bill:one
     *
     * @see BillService#findBill(BillVo)
     */
    @GetMapping("/one")
    public BaseRsp<BillVo> findBill(@Validated BillVo billVo) {
        BillVo bill = this.billService.findBill(billVo);
        return RspUtil.data(bill);
    }

    /**
     * 新增对账单
     * 权限: bill:add
     *
     * @see BillService#createBill(BillAo)
     */
    @PostMapping
    public BaseRsp<Bill> addBill(@Validated @RequestBody BillAo billAo) {
        return RspUtil.data(this.billService.createBill(billAo));
    }

    /**
     * 修改对账单
     * 权限: bill:update
     *
     * @see BillService#updateBill(BillAo)
     */
    @PutMapping
    public BaseRsp<Bill> updateBill(@Validated({ValidGroups.Crud.Update.class}) @RequestBody BillAo billAo) {
        return RspUtil.data(this.billService.updateBill(billAo));
    }

    /**
     * 新增或修改对账单
     * 权限: bill:createOrUpdate
     *
     * @see BillService#createOrUpdateBill(BillAo)
     */
    @PostMapping("/createOrUpdate")
    public BaseRsp<Bill> createOrUpdateBill(@RequestBody @Validated BillAo billAo) {
        return RspUtil.data(this.billService.createOrUpdateBill(billAo));
    }

    /**
     * 删除对账单
     * 权限: bill:delete
     *
     * @param billIds 对账单id集合(,分隔)
     * @see BillService#deleteBill(List)
     */
    @DeleteMapping("/{billIds}")
    public BaseRsp<String> deleteBill(@NotBlank(message = "{required}") @PathVariable String billIds) {
        List<Long> ids = Arrays.stream(billIds.split(Strings.COMMA)).map(Long::valueOf).collect(Collectors.toList());
        this.billService.deleteBill(ids);
        return RspUtil.message("删除成功");
    }

    /**
     * 批量新增对账单
     * 权限: bill:add:batch
     *
     * @see BillService#createBillBatch(List)
     */
    @PostMapping("/batch")
    public BaseRsp<List<Bill>> createBillBatch(@RequestBody @Validated ValidatedList<BillAo> billAos) {
        return RspUtil.data(this.billService.createBillBatch(billAos));
    }

    /**
     * 批量修改对账单
     * 权限: bill:update:batch
     *
     * @see BillService#createOrUpdateBillBatch(List)
     */
    @PutMapping("/batch")
    public BaseRsp<List<Bill>> updateBillBatch(@RequestBody @Validated({ValidGroups.Crud.Update.class}) ValidatedList<BillAo> billAos) {
        return RspUtil.data(this.billService.updateBillBatch(billAos));
    }

    /**
     * 批量新增或修改对账单
     * id为空则新增，不为空则修改
     * 权限: bill:createOrUpdate:batch
     *
     * @see BillService#createOrUpdateBillBatch(List)
     */
    @PostMapping("/createOrUpdate/batch")
    public BaseRsp<List<Bill>> createOrUpdateBillBatch(@RequestBody @Validated ValidatedList<BillAo> billAos) {
        return RspUtil.data(this.billService.createOrUpdateBillBatch(billAos));
    }
}