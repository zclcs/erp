package com.zclcs.erp.service;

import com.mybatisflex.core.service.IService;
import com.zclcs.erp.api.bean.ao.ProductCompanyAo;
import com.zclcs.erp.api.bean.entity.ProductCompany;
import com.zclcs.erp.api.bean.vo.ProductCompanyVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;

import java.util.List;

/**
 * 进货公司 Service接口
 *
 * @author zclcs
 * @since 2023-09-14 11:36:22.587
 */
public interface ProductCompanyService extends IService<ProductCompany> {

    /**
     * 查询（分页）
     *
     * @param basePageAo       {@link BasePageAo}
     * @param productCompanyVo {@link ProductCompanyVo}
     * @return {@link ProductCompanyVo}
     */
    BasePage<ProductCompanyVo> findProductCompanyPage(BasePageAo basePageAo, ProductCompanyVo productCompanyVo);

    /**
     * 查询（所有）
     *
     * @param productCompanyVo {@link ProductCompanyVo}
     * @return {@link ProductCompanyVo}
     */
    List<ProductCompanyVo> findProductCompanyList(ProductCompanyVo productCompanyVo);

    /**
     * 查询（单个）
     *
     * @param productCompanyVo {@link ProductCompanyVo}
     * @return {@link ProductCompanyVo}
     */
    ProductCompanyVo findProductCompany(ProductCompanyVo productCompanyVo);

    /**
     * 统计
     *
     * @param productCompanyVo {@link ProductCompanyVo}
     * @return 统计值
     */
    Long countProductCompany(ProductCompanyVo productCompanyVo);

    /**
     * 新增
     *
     * @param productCompanyAo {@link ProductCompanyAo}
     * @return {@link ProductCompany}
     */
    ProductCompany createProductCompany(ProductCompanyAo productCompanyAo);

    /**
     * 修改
     *
     * @param productCompanyAo {@link ProductCompanyAo}
     * @return {@link ProductCompany}
     */
    ProductCompany updateProductCompany(ProductCompanyAo productCompanyAo);

    /**
     * 新增或修改
     *
     * @param productCompanyAo {@link ProductCompanyAo}
     * @return {@link ProductCompany}
     */
    ProductCompany createOrUpdateProductCompany(ProductCompanyAo productCompanyAo);

    /**
     * 批量新增
     *
     * @param productCompanyAos {@link ProductCompanyAo}
     * @return {@link ProductCompany}
     */
    List<ProductCompany> createProductCompanyBatch(List<ProductCompanyAo> productCompanyAos);

    /**
     * 批量修改
     *
     * @param productCompanyAos {@link ProductCompanyAo}
     * @return {@link ProductCompany}
     */
    List<ProductCompany> updateProductCompanyBatch(List<ProductCompanyAo> productCompanyAos);

    /**
     * 批量新增或修改
     * id为空则新增，不为空则修改
     * 可以自行重写
     *
     * @param productCompanyAos {@link ProductCompanyAo}
     * @return {@link ProductCompany}
     */
    List<ProductCompany> createOrUpdateProductCompanyBatch(List<ProductCompanyAo> productCompanyAos);

    /**
     * 删除
     *
     * @param ids 表id集合
     */
    void deleteProductCompany(List<Long> ids);

}
