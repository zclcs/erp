package com.zclcs.erp.controller;

import com.zclcs.erp.api.bean.ao.PurchaseAo;
import com.zclcs.erp.api.bean.entity.Purchase;
import com.zclcs.erp.api.bean.vo.PurchaseVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.core.base.BaseRsp;
import com.zclcs.erp.core.bean.ValidatedList;
import com.zclcs.erp.core.constant.Strings;
import com.zclcs.erp.core.strategy.ValidGroups;
import com.zclcs.erp.service.PurchaseService;
import com.zclcs.erp.utils.RspUtil;
import jakarta.validation.constraints.NotBlank;
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
 * 进货单
 *
 * @author zclcs
 * @since 2023-09-14 11:36:17.891
 */
@Slf4j
@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    /**
     * 进货单查询（分页）
     * 权限: purchase:page
     *
     * @see PurchaseService#findPurchasePage(BasePageAo, PurchaseVo)
     */
    @GetMapping
    public BaseRsp<PurchaseVo> findPurchasePage(@Validated BasePageAo basePageAo, @Validated PurchaseVo purchaseVo) {
        BasePage<PurchaseVo> page = this.purchaseService.findPurchasePage(basePageAo, purchaseVo);
        Map<String, Object> totalRow = new HashMap<>(1);
        BigDecimal purchaseAmount = new BigDecimal("0");
        for (PurchaseVo vo : page.getList()) {
            if (vo.getPurchaseAmount() != null) {
                purchaseAmount = purchaseAmount.add(vo.getPurchaseAmount());
            }
        }
        totalRow.put("purchaseAmount", purchaseAmount);
        return RspUtil.page(page, totalRow);
    }

    /**
     * 进货单查询（集合）
     * 权限: purchase:list
     *
     * @see PurchaseService#findPurchaseList(PurchaseVo)
     */
    @GetMapping("/list")
    public BaseRsp<List<PurchaseVo>> findPurchaseList(@Validated PurchaseVo purchaseVo) {
        List<PurchaseVo> list = this.purchaseService.findPurchaseList(purchaseVo);
        return RspUtil.data(list);
    }

    /**
     * 进货单查询（单个）
     * 权限: purchase:one
     *
     * @see PurchaseService#findPurchase(PurchaseVo)
     */
    @GetMapping("/one")
    public BaseRsp<PurchaseVo> findPurchase(@Validated PurchaseVo purchaseVo) {
        PurchaseVo purchase = this.purchaseService.findPurchase(purchaseVo);
        return RspUtil.data(purchase);
    }

    /**
     * 新增进货单
     * 权限: purchase:add
     *
     * @see PurchaseService#createPurchase(PurchaseAo)
     */
    @PostMapping
    public BaseRsp<Purchase> addPurchase(@Validated @RequestBody PurchaseAo purchaseAo) {
        return RspUtil.data(this.purchaseService.createPurchase(purchaseAo));
    }

    /**
     * 修改进货单
     * 权限: purchase:update
     *
     * @see PurchaseService#updatePurchase(PurchaseAo)
     */
    @PutMapping
    public BaseRsp<Purchase> updatePurchase(@Validated({ValidGroups.Crud.Update.class}) @RequestBody PurchaseAo purchaseAo) {
        return RspUtil.data(this.purchaseService.updatePurchase(purchaseAo));
    }

    /**
     * 新增或修改进货单
     * 权限: purchase:createOrUpdate
     *
     * @see PurchaseService#createOrUpdatePurchase(PurchaseAo)
     */
    @PostMapping("/createOrUpdate")
    public BaseRsp<Purchase> createOrUpdatePurchase(@RequestBody @Validated PurchaseAo purchaseAo) {
        return RspUtil.data(this.purchaseService.createOrUpdatePurchase(purchaseAo));
    }

    /**
     * 删除进货单
     * 权限: purchase:delete
     *
     * @param purchaseIds 进货单id集合(,分隔)
     * @see PurchaseService#deletePurchase(List)
     */
    @DeleteMapping("/{purchaseIds}")
    public BaseRsp<String> deletePurchase(@NotBlank(message = "{required}") @PathVariable String purchaseIds) {
        List<Long> ids = Arrays.stream(purchaseIds.split(Strings.COMMA)).map(Long::valueOf).collect(Collectors.toList());
        this.purchaseService.deletePurchase(ids);
        return RspUtil.message("删除成功");
    }

    /**
     * 批量新增进货单
     * 权限: purchase:add:batch
     *
     * @see PurchaseService#createPurchaseBatch(List)
     */
    @PostMapping("/batch")
    public BaseRsp<List<Purchase>> createPurchaseBatch(@RequestBody @Validated ValidatedList<PurchaseAo> purchaseAos) {
        return RspUtil.data(this.purchaseService.createPurchaseBatch(purchaseAos));
    }

    /**
     * 批量修改进货单
     * 权限: purchase:update:batch
     *
     * @see PurchaseService#createOrUpdatePurchaseBatch(List)
     */
    @PutMapping("/batch")
    public BaseRsp<List<Purchase>> updatePurchaseBatch(@RequestBody @Validated({ValidGroups.Crud.Update.class}) ValidatedList<PurchaseAo> purchaseAos) {
        return RspUtil.data(this.purchaseService.updatePurchaseBatch(purchaseAos));
    }

    /**
     * 批量新增或修改进货单
     * id为空则新增，不为空则修改
     * 权限: purchase:createOrUpdate:batch
     *
     * @see PurchaseService#createOrUpdatePurchaseBatch(List)
     */
    @PostMapping("/createOrUpdate/batch")
    public BaseRsp<List<Purchase>> createOrUpdatePurchaseBatch(@RequestBody @Validated ValidatedList<PurchaseAo> purchaseAos) {
        return RspUtil.data(this.purchaseService.createOrUpdatePurchaseBatch(purchaseAos));
    }

}