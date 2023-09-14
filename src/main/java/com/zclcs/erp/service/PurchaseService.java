package com.zclcs.erp.service;

import com.mybatisflex.core.service.IService;
import com.zclcs.erp.api.bean.ao.PurchaseAo;
import com.zclcs.erp.api.bean.entity.Purchase;
import com.zclcs.erp.api.bean.vo.PurchaseVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;

import java.util.List;

/**
 * 进货单 Service接口
 *
 * @author zclcs
 * @since 2023-09-14 11:36:17.891
 */
public interface PurchaseService extends IService<Purchase> {

    /**
     * 查询（分页）
     *
     * @param basePageAo {@link BasePageAo}
     * @param purchaseVo {@link PurchaseVo}
     * @return {@link PurchaseVo}
     */
    BasePage<PurchaseVo> findPurchasePage(BasePageAo basePageAo, PurchaseVo purchaseVo);

    /**
     * 查询（所有）
     *
     * @param purchaseVo {@link PurchaseVo}
     * @return {@link PurchaseVo}
     */
    List<PurchaseVo> findPurchaseList(PurchaseVo purchaseVo);

    /**
     * 查询（单个）
     *
     * @param purchaseVo {@link PurchaseVo}
     * @return {@link PurchaseVo}
     */
    PurchaseVo findPurchase(PurchaseVo purchaseVo);

    /**
     * 统计
     *
     * @param purchaseVo {@link PurchaseVo}
     * @return 统计值
     */
    Long countPurchase(PurchaseVo purchaseVo);

    /**
     * 新增
     *
     * @param purchaseAo {@link PurchaseAo}
     * @return {@link Purchase}
     */
    Purchase createPurchase(PurchaseAo purchaseAo);

    /**
     * 修改
     *
     * @param purchaseAo {@link PurchaseAo}
     * @return {@link Purchase}
     */
    Purchase updatePurchase(PurchaseAo purchaseAo);

    /**
     * 新增或修改
     *
     * @param purchaseAo {@link PurchaseAo}
     * @return {@link Purchase}
     */
    Purchase createOrUpdatePurchase(PurchaseAo purchaseAo);

    /**
     * 批量新增
     *
     * @param purchaseAos {@link PurchaseAo}
     * @return {@link Purchase}
     */
    List<Purchase> createPurchaseBatch(List<PurchaseAo> purchaseAos);

    /**
     * 批量修改
     *
     * @param purchaseAos {@link PurchaseAo}
     * @return {@link Purchase}
     */
    List<Purchase> updatePurchaseBatch(List<PurchaseAo> purchaseAos);

    /**
     * 批量新增或修改
     * id为空则新增，不为空则修改
     * 可以自行重写
     *
     * @param purchaseAos {@link PurchaseAo}
     * @return {@link Purchase}
     */
    List<Purchase> createOrUpdatePurchaseBatch(List<PurchaseAo> purchaseAos);

    /**
     * 删除
     *
     * @param ids 表id集合
     */
    void deletePurchase(List<Long> ids);

}
