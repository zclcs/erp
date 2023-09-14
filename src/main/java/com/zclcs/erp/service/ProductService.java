package com.zclcs.erp.service;

import com.mybatisflex.core.service.IService;
import com.zclcs.erp.api.bean.ao.ProductAo;
import com.zclcs.erp.api.bean.entity.Product;
import com.zclcs.erp.api.bean.vo.ProductVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;

import java.util.List;

/**
 * 产品 Service接口
 *
 * @author zclcs
 * @since 2023-09-14 11:36:26.807
 */
public interface ProductService extends IService<Product> {

    /**
     * 查询（分页）
     *
     * @param basePageAo {@link BasePageAo}
     * @param productVo  {@link ProductVo}
     * @return {@link ProductVo}
     */
    BasePage<ProductVo> findProductPage(BasePageAo basePageAo, ProductVo productVo);

    /**
     * 查询（所有）
     *
     * @param productVo {@link ProductVo}
     * @return {@link ProductVo}
     */
    List<ProductVo> findProductList(ProductVo productVo);

    /**
     * 查询（单个）
     *
     * @param productVo {@link ProductVo}
     * @return {@link ProductVo}
     */
    ProductVo findProduct(ProductVo productVo);

    /**
     * 统计
     *
     * @param productVo {@link ProductVo}
     * @return 统计值
     */
    Long countProduct(ProductVo productVo);

    /**
     * 新增
     *
     * @param productAo {@link ProductAo}
     * @return {@link Product}
     */
    Product createProduct(ProductAo productAo);

    /**
     * 修改
     *
     * @param productAo {@link ProductAo}
     * @return {@link Product}
     */
    Product updateProduct(ProductAo productAo);

    /**
     * 新增或修改
     *
     * @param productAo {@link ProductAo}
     * @return {@link Product}
     */
    Product createOrUpdateProduct(ProductAo productAo);

    /**
     * 批量新增
     *
     * @param productAos {@link ProductAo}
     * @return {@link Product}
     */
    List<Product> createProductBatch(List<ProductAo> productAos);

    /**
     * 批量修改
     *
     * @param productAos {@link ProductAo}
     * @return {@link Product}
     */
    List<Product> updateProductBatch(List<ProductAo> productAos);

    /**
     * 批量新增或修改
     * id为空则新增，不为空则修改
     * 可以自行重写
     *
     * @param productAos {@link ProductAo}
     * @return {@link Product}
     */
    List<Product> createOrUpdateProductBatch(List<ProductAo> productAos);

    /**
     * 删除
     *
     * @param ids 表id集合
     */
    void deleteProduct(List<Long> ids);

}
