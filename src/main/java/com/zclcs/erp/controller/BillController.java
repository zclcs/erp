package com.zclcs.erp.controller;

import com.zclcs.erp.api.bean.ao.BillAo;
import com.zclcs.erp.api.bean.vo.BillVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.core.base.BaseRsp;
import com.zclcs.erp.core.constant.Strings;
import com.zclcs.erp.core.strategy.ValidGroups;
import com.zclcs.erp.service.BillService;
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
    public BaseRsp<BillVo> findBillPage(@Validated BasePageAo basePageAo, @Validated BillVo billVo) {
        BasePage<BillVo> page = this.billService.findBillPage(basePageAo, billVo);
        Map<String, Object> totalRow = new HashMap<>(1);
        BigDecimal totalAmount = new BigDecimal("0");
        for (BillVo vo : page.getList()) {
            if (vo.getTotalAmount() != null) {
                totalAmount = totalAmount.add(vo.getTotalAmount());
            }
        }
        totalRow.put("totalAmount", totalAmount);
        return RspUtil.page(page, totalRow);
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
    public BaseRsp<String> addBill(@Validated({ValidGroups.Crud.Create.class}) @RequestBody BillAo billAo) {
        this.billService.createBill(billAo);
        return RspUtil.message();
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
     * 导出对账单
     *
     * @param id   id
     * @param type 1 doc 2 pdf
     */
    @GetMapping("/exportBill")
    public void exportBill(@NotNull(message = "{required}") @RequestParam Long id, @NotNull(message = "{required}") @RequestParam Integer type) {
        billService.exportBill(id, type);
    }

}