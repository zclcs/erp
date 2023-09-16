package com.zclcs.erp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.If;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.zclcs.erp.api.bean.ao.ProductCompanyAo;
import com.zclcs.erp.api.bean.entity.ProductCompany;
import com.zclcs.erp.api.bean.vo.ProductCompanyVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.exception.FieldException;
import com.zclcs.erp.mapper.ProductCompanyMapper;
import com.zclcs.erp.service.ProductCompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.zclcs.erp.api.bean.entity.table.ProductCompanyTableDef.PRODUCT_COMPANY;

/**
 * 进货公司 Service实现
 *
 * @author zclcs
 * @since 2023-09-14 11:36:22.587
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCompanyServiceImpl extends ServiceImpl<ProductCompanyMapper, ProductCompany> implements ProductCompanyService {

    @Override
    public BasePage<ProductCompanyVo> findProductCompanyPage(BasePageAo basePageAo, ProductCompanyVo productCompanyVo) {
        QueryWrapper queryWrapper = getQueryWrapper(productCompanyVo);
        Page<ProductCompanyVo> page = this.mapper.paginateAs(basePageAo.getPage(), basePageAo.getLimit(), queryWrapper, ProductCompanyVo.class);
        return new BasePage<>(page);
    }

    @Override
    public List<ProductCompanyVo> findProductCompanyList(ProductCompanyVo productCompanyVo) {
        QueryWrapper queryWrapper = getQueryWrapper(productCompanyVo);
        return this.mapper.selectListByQueryAs(queryWrapper, ProductCompanyVo.class);
    }

    @Override
    public ProductCompanyVo findProductCompany(ProductCompanyVo productCompanyVo) {
        QueryWrapper queryWrapper = getQueryWrapper(productCompanyVo);
        return this.mapper.selectOneByQueryAs(queryWrapper, ProductCompanyVo.class);
    }

    @Override
    public Long countProductCompany(ProductCompanyVo productCompanyVo) {
        QueryWrapper queryWrapper = getQueryWrapper(productCompanyVo);
        return this.mapper.selectCountByQuery(queryWrapper);
    }

    private QueryWrapper getQueryWrapper(ProductCompanyVo productCompanyVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(
                        PRODUCT_COMPANY.ID,
                        PRODUCT_COMPANY.NAME,
                        PRODUCT_COMPANY.REMARK
                )
                .where(PRODUCT_COMPANY.NAME.like(productCompanyVo.getName(), If::hasText))
                .orderBy(PRODUCT_COMPANY.ID.desc())
        ;
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProductCompany createProductCompany(ProductCompanyAo productCompanyAo) {
        validateName(productCompanyAo.getName(), productCompanyAo.getId());
        ProductCompany productCompany = new ProductCompany();
        BeanUtil.copyProperties(productCompanyAo, productCompany);
        this.save(productCompany);
        return productCompany;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProductCompany updateProductCompany(ProductCompanyAo productCompanyAo) {
        validateName(productCompanyAo.getName(), productCompanyAo.getId());
        ProductCompany productCompany = new ProductCompany();
        BeanUtil.copyProperties(productCompanyAo, productCompany);
        this.updateById(productCompany);
        return productCompany;
    }

    @Override
    public ProductCompany createOrUpdateProductCompany(ProductCompanyAo productCompanyAo) {
        ProductCompany productCompany = new ProductCompany();
        BeanUtil.copyProperties(productCompanyAo, productCompany);
        this.saveOrUpdate(productCompany);
        return productCompany;
    }

    @Override
    public List<ProductCompany> createProductCompanyBatch(List<ProductCompanyAo> productCompanyAos) {
        List<ProductCompany> productCompanyList = new ArrayList<>();
        for (ProductCompanyAo productCompanyAo : productCompanyAos) {
            ProductCompany productCompany = new ProductCompany();
            BeanUtil.copyProperties(productCompanyAo, productCompany);
            productCompanyList.add(productCompany);
        }
        saveBatch(productCompanyList);
        return productCompanyList;
    }

    @Override
    public List<ProductCompany> updateProductCompanyBatch(List<ProductCompanyAo> productCompanyAos) {
        List<ProductCompany> productCompanyList = new ArrayList<>();
        for (ProductCompanyAo productCompanyAo : productCompanyAos) {
            ProductCompany productCompany = new ProductCompany();
            BeanUtil.copyProperties(productCompanyAo, productCompany);
            productCompanyList.add(productCompany);
        }
        updateBatch(productCompanyList);
        return productCompanyList;
    }

    @Override
    public List<ProductCompany> createOrUpdateProductCompanyBatch(List<ProductCompanyAo> productCompanyAos) {
        List<ProductCompany> productCompanyList = new ArrayList<>();
        for (ProductCompanyAo productCompanyAo : productCompanyAos) {
            ProductCompany productCompany = new ProductCompany();
            BeanUtil.copyProperties(productCompanyAo, productCompany);
            productCompanyList.add(productCompany);
        }
        saveOrUpdateBatch(productCompanyList);
        return productCompanyList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteProductCompany(List<Long> ids) {
        this.removeByIds(ids);
    }

    @Override
    public void validateName(String name, Long id) {
        ProductCompany one = this.getOne(new QueryWrapper().where(PRODUCT_COMPANY.NAME.eq(name)));
        if (one != null && !one.getId().equals(id)) {
            throw new FieldException("进货公司名称重复");
        }
    }

}
