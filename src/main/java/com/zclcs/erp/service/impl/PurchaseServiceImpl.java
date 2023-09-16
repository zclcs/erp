package com.zclcs.erp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.If;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.zclcs.erp.api.bean.ao.PurchaseAo;
import com.zclcs.erp.api.bean.entity.ProductCompany;
import com.zclcs.erp.api.bean.entity.Purchase;
import com.zclcs.erp.api.bean.vo.PurchaseVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.mapper.PurchaseMapper;
import com.zclcs.erp.service.ProductCompanyService;
import com.zclcs.erp.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.zclcs.erp.api.bean.entity.table.PurchaseTableDef.PURCHASE;

/**
 * 进货单 Service实现
 *
 * @author zclcs
 * @since 2023-09-14 11:36:17.891
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {

    private final ProductCompanyService productCompanyService;

    @Override
    public BasePage<PurchaseVo> findPurchasePage(BasePageAo basePageAo, PurchaseVo purchaseVo) {
        QueryWrapper queryWrapper = getQueryWrapper(purchaseVo);
        Page<PurchaseVo> page = this.mapper.paginateAs(basePageAo.getPage(), basePageAo.getLimit(), queryWrapper, PurchaseVo.class);
        return new BasePage<>(page);
    }

    @Override
    public List<PurchaseVo> findPurchaseList(PurchaseVo purchaseVo) {
        QueryWrapper queryWrapper = getQueryWrapper(purchaseVo);
        return this.mapper.selectListByQueryAs(queryWrapper, PurchaseVo.class);
    }

    @Override
    public PurchaseVo findPurchase(PurchaseVo purchaseVo) {
        QueryWrapper queryWrapper = getQueryWrapper(purchaseVo);
        return this.mapper.selectOneByQueryAs(queryWrapper, PurchaseVo.class);
    }

    @Override
    public Long countPurchase(PurchaseVo purchaseVo) {
        QueryWrapper queryWrapper = getQueryWrapper(purchaseVo);
        return this.mapper.selectCountByQuery(queryWrapper);
    }

    private QueryWrapper getQueryWrapper(PurchaseVo purchaseVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(
                        PURCHASE.ID,
                        PURCHASE.PRODUCT_COMPANY_ID,
                        PURCHASE.PRODUCT_COMPANY_NAME,
                        PURCHASE.PURCHASE_DATE,
                        PURCHASE.PURCHASE_AMOUNT
                )
                .where(PURCHASE.PRODUCT_COMPANY_NAME.like(purchaseVo.getProductCompanyName(), If::hasText))
        ;
        String purchaseDateMonth = purchaseVo.getPurchaseDateMonth();
        if (StrUtil.isNotBlank(purchaseDateMonth)) {
            DateTime dataMonth = DateUtil.parse(purchaseDateMonth, DatePattern.NORM_MONTH_FORMAT);
            queryWrapper.and(PURCHASE.PURCHASE_DATE.between(DateUtil.beginOfMonth(dataMonth).toString(DatePattern.NORM_DATE_PATTERN), DateUtil.endOfMonth(dataMonth).toString(DatePattern.NORM_DATE_PATTERN)));
        }
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Purchase createPurchase(PurchaseAo purchaseAo) {
        Purchase purchase = new Purchase();
        BeanUtil.copyProperties(purchaseAo, purchase);
        setPurchase(purchase);
        this.save(purchase);
        return purchase;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Purchase updatePurchase(PurchaseAo purchaseAo) {
        Purchase purchase = new Purchase();
        BeanUtil.copyProperties(purchaseAo, purchase);
        setPurchase(purchase);
        this.updateById(purchase);
        return purchase;
    }

    @Override
    public Purchase createOrUpdatePurchase(PurchaseAo purchaseAo) {
        Purchase purchase = new Purchase();
        BeanUtil.copyProperties(purchaseAo, purchase);
        this.saveOrUpdate(purchase);
        return purchase;
    }

    @Override
    public List<Purchase> createPurchaseBatch(List<PurchaseAo> purchaseAos) {
        List<Purchase> purchaseList = new ArrayList<>();
        for (PurchaseAo purchaseAo : purchaseAos) {
            Purchase purchase = new Purchase();
            BeanUtil.copyProperties(purchaseAo, purchase);
            purchaseList.add(purchase);
        }
        saveBatch(purchaseList);
        return purchaseList;
    }

    @Override
    public List<Purchase> updatePurchaseBatch(List<PurchaseAo> purchaseAos) {
        List<Purchase> purchaseList = new ArrayList<>();
        for (PurchaseAo purchaseAo : purchaseAos) {
            Purchase purchase = new Purchase();
            BeanUtil.copyProperties(purchaseAo, purchase);
            purchaseList.add(purchase);
        }
        updateBatch(purchaseList);
        return purchaseList;
    }

    @Override
    public List<Purchase> createOrUpdatePurchaseBatch(List<PurchaseAo> purchaseAos) {
        List<Purchase> purchaseList = new ArrayList<>();
        for (PurchaseAo purchaseAo : purchaseAos) {
            Purchase purchase = new Purchase();
            BeanUtil.copyProperties(purchaseAo, purchase);
            purchaseList.add(purchase);
        }
        saveOrUpdateBatch(purchaseList);
        return purchaseList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePurchase(List<Long> ids) {
        this.removeByIds(ids);
    }

    private void setPurchase(Purchase purchase) {
        ProductCompany byId = productCompanyService.getById(purchase.getProductCompanyId());
        purchase.setProductCompanyName(byId.getName());
    }

}
