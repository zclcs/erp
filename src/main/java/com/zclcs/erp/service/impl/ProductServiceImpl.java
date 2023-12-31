package com.zclcs.erp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.If;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.zclcs.erp.api.bean.ao.ProductAo;
import com.zclcs.erp.api.bean.entity.Product;
import com.zclcs.erp.api.bean.vo.ProductVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.exception.FieldException;
import com.zclcs.erp.mapper.ChildOrderMapper;
import com.zclcs.erp.mapper.ProductMapper;
import com.zclcs.erp.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.zclcs.erp.api.bean.entity.table.ChildOrderTableDef.CHILD_ORDER;
import static com.zclcs.erp.api.bean.entity.table.ProductTableDef.PRODUCT;

/**
 * 产品 Service实现
 *
 * @author zclcs
 * @since 2023-09-14 11:36:26.807
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    private final ChildOrderMapper childOrderMapper;

    @Override
    public BasePage<ProductVo> findProductPage(BasePageAo basePageAo, ProductVo productVo) {
        QueryWrapper queryWrapper = getQueryWrapper(productVo);
        Page<ProductVo> page = this.mapper.paginateAs(basePageAo.getPage(), basePageAo.getLimit(), queryWrapper, ProductVo.class);
        return new BasePage<>(page);
    }

    @Override
    public List<ProductVo> findProductList(ProductVo productVo) {
        QueryWrapper queryWrapper = getQueryWrapper(productVo);
        return this.mapper.selectListByQueryAs(queryWrapper, ProductVo.class);
    }

    @Override
    public ProductVo findProduct(ProductVo productVo) {
        QueryWrapper queryWrapper = getQueryWrapper(productVo);
        return this.mapper.selectOneByQueryAs(queryWrapper, ProductVo.class);
    }

    @Override
    public Long countProduct(ProductVo productVo) {
        QueryWrapper queryWrapper = getQueryWrapper(productVo);
        return this.mapper.selectCountByQuery(queryWrapper);
    }

    private QueryWrapper getQueryWrapper(ProductVo productVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(
                        PRODUCT.ID,
                        PRODUCT.NAME,
                        PRODUCT.REMARK
                )
                .where(PRODUCT.NAME.like(productVo.getName(), If::hasText))
                .orderBy(PRODUCT.ID.desc())
        ;
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Product createProduct(ProductAo productAo) {
        validateName(productAo.getName(), productAo.getId());
        Product product = new Product();
        BeanUtil.copyProperties(productAo, product);
        this.save(product);
        return product;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Product updateProduct(ProductAo productAo) {
        validateName(productAo.getName(), productAo.getId());
        Product product = new Product();
        BeanUtil.copyProperties(productAo, product);
        this.updateById(product);
        return product;
    }

    @Override
    public Product createOrUpdateProduct(ProductAo productAo) {
        Product product = new Product();
        BeanUtil.copyProperties(productAo, product);
        this.saveOrUpdate(product);
        return product;
    }

    @Override
    public List<Product> createProductBatch(List<ProductAo> productAos) {
        List<Product> productList = new ArrayList<>();
        for (ProductAo productAo : productAos) {
            Product product = new Product();
            BeanUtil.copyProperties(productAo, product);
            productList.add(product);
        }
        saveBatch(productList);
        return productList;
    }

    @Override
    public List<Product> updateProductBatch(List<ProductAo> productAos) {
        List<Product> productList = new ArrayList<>();
        for (ProductAo productAo : productAos) {
            Product product = new Product();
            BeanUtil.copyProperties(productAo, product);
            productList.add(product);
        }
        updateBatch(productList);
        return productList;
    }

    @Override
    public List<Product> createOrUpdateProductBatch(List<ProductAo> productAos) {
        List<Product> productList = new ArrayList<>();
        for (ProductAo productAo : productAos) {
            Product product = new Product();
            BeanUtil.copyProperties(productAo, product);
            productList.add(product);
        }
        saveOrUpdateBatch(productList);
        return productList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteProduct(List<Long> ids) {
        if (childOrderMapper.selectCountByQuery(new QueryWrapper().where(CHILD_ORDER.PRODUCT_ID.in(ids))) != 0L) {
            throw new FieldException("该产品已创建子订单，不能删除，请删除对应子订单之后再操作");
        }
        this.removeByIds(ids);
    }

    @Override
    public void validateName(String name, Long id) {
        Product one = this.getOne(new QueryWrapper().where(PRODUCT.NAME.eq(name)));
        if (one != null && !one.getId().equals(id)) {
            throw new FieldException("产品名称重复");
        }
    }

}
