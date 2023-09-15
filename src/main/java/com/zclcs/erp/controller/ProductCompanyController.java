package com.zclcs.erp.controller;

import com.zclcs.erp.api.bean.ao.ProductCompanyAo;
import com.zclcs.erp.api.bean.entity.ProductCompany;
import com.zclcs.erp.api.bean.vo.ProductCompanyVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.core.base.BaseRsp;
import com.zclcs.erp.core.bean.ValidatedList;
import com.zclcs.erp.core.constant.Strings;
import com.zclcs.erp.core.strategy.ValidGroups;
import com.zclcs.erp.service.ProductCompanyService;
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
 * 进货公司
 *
 * @author zclcs
 * @since 2023-09-14 11:36:22.587
 */
@Slf4j
@RestController
@RequestMapping("/productCompany")
@RequiredArgsConstructor
public class ProductCompanyController {

    private final ProductCompanyService productCompanyService;

    /**
     * 进货公司查询（分页）
     * 权限: productCompany:page
     *
     * @see ProductCompanyService#findProductCompanyPage(BasePageAo, ProductCompanyVo)
     */
    @GetMapping
    public BaseRsp<ProductCompanyVo> findProductCompanyPage(@Validated BasePageAo basePageAo, @Validated ProductCompanyVo productCompanyVo) {
        BasePage<ProductCompanyVo> page = this.productCompanyService.findProductCompanyPage(basePageAo, productCompanyVo);
        return RspUtil.page(page);
    }

    /**
     * 进货公司查询（集合）
     * 权限: productCompany:list
     *
     * @see ProductCompanyService#findProductCompanyList(ProductCompanyVo)
     */
    @GetMapping("/list")
    public BaseRsp<List<ProductCompanyVo>> findProductCompanyList(@Validated ProductCompanyVo productCompanyVo) {
        List<ProductCompanyVo> list = this.productCompanyService.findProductCompanyList(productCompanyVo);
        return RspUtil.data(list);
    }

    /**
     * 进货公司查询（单个）
     * 权限: productCompany:one
     *
     * @see ProductCompanyService#findProductCompany(ProductCompanyVo)
     */
    @GetMapping("/one")
    public BaseRsp<ProductCompanyVo> findProductCompany(@Validated ProductCompanyVo productCompanyVo) {
        ProductCompanyVo productCompany = this.productCompanyService.findProductCompany(productCompanyVo);
        return RspUtil.data(productCompany);
    }

    /**
     * 新增进货公司
     * 权限: productCompany:add
     *
     * @see ProductCompanyService#createProductCompany(ProductCompanyAo)
     */
    @PostMapping
    public BaseRsp<ProductCompany> addProductCompany(@Validated @RequestBody ProductCompanyAo productCompanyAo) {
        return RspUtil.data(this.productCompanyService.createProductCompany(productCompanyAo));
    }

    /**
     * 修改进货公司
     * 权限: productCompany:update
     *
     * @see ProductCompanyService#updateProductCompany(ProductCompanyAo)
     */
    @PutMapping
    public BaseRsp<ProductCompany> updateProductCompany(@Validated({ValidGroups.Crud.Update.class}) @RequestBody ProductCompanyAo productCompanyAo) {
        return RspUtil.data(this.productCompanyService.updateProductCompany(productCompanyAo));
    }

    /**
     * 新增或修改进货公司
     * 权限: productCompany:createOrUpdate
     *
     * @see ProductCompanyService#createOrUpdateProductCompany(ProductCompanyAo)
     */
    @PostMapping("/createOrUpdate")
    public BaseRsp<ProductCompany> createOrUpdateProductCompany(@RequestBody @Validated ProductCompanyAo productCompanyAo) {
        return RspUtil.data(this.productCompanyService.createOrUpdateProductCompany(productCompanyAo));
    }

    /**
     * 删除进货公司
     * 权限: productCompany:delete
     *
     * @param productCompanyIds 进货公司id集合(,分隔)
     * @see ProductCompanyService#deleteProductCompany(List)
     */
    @DeleteMapping("/{productCompanyIds}")
    public BaseRsp<String> deleteProductCompany(@NotBlank(message = "{required}") @PathVariable String productCompanyIds) {
        List<Long> ids = Arrays.stream(productCompanyIds.split(Strings.COMMA)).map(Long::valueOf).collect(Collectors.toList());
        this.productCompanyService.deleteProductCompany(ids);
        return RspUtil.message("删除成功");
    }

    /**
     * 批量新增进货公司
     * 权限: productCompany:add:batch
     *
     * @see ProductCompanyService#createProductCompanyBatch(List)
     */
    @PostMapping("/batch")
    public BaseRsp<List<ProductCompany>> createProductCompanyBatch(@RequestBody @Validated ValidatedList<ProductCompanyAo> productCompanyAos) {
        return RspUtil.data(this.productCompanyService.createProductCompanyBatch(productCompanyAos));
    }

    /**
     * 批量修改进货公司
     * 权限: productCompany:update:batch
     *
     * @see ProductCompanyService#createOrUpdateProductCompanyBatch(List)
     */
    @PutMapping("/batch")
    public BaseRsp<List<ProductCompany>> updateProductCompanyBatch(@RequestBody @Validated({ValidGroups.Crud.Update.class}) ValidatedList<ProductCompanyAo> productCompanyAos) {
        return RspUtil.data(this.productCompanyService.updateProductCompanyBatch(productCompanyAos));
    }

    /**
     * 批量新增或修改进货公司
     * id为空则新增，不为空则修改
     * 权限: productCompany:createOrUpdate:batch
     *
     * @see ProductCompanyService#createOrUpdateProductCompanyBatch(List)
     */
    @PostMapping("/createOrUpdate/batch")
    public BaseRsp<List<ProductCompany>> createOrUpdateProductCompanyBatch(@RequestBody @Validated ValidatedList<ProductCompanyAo> productCompanyAos) {
        return RspUtil.data(this.productCompanyService.createOrUpdateProductCompanyBatch(productCompanyAos));
    }

    /**
     * 检查进货公司名称
     *
     * @param id   进货公司id
     * @param name 进货公司名称
     * @return 是否成功
     */
    @GetMapping("/checkName")
    public BaseRsp<Object> checkName(@RequestParam(required = false) Long id,
                                     @NotBlank(message = "{required}") @RequestParam String name) {
        productCompanyService.validateName(name, id);
        return RspUtil.message();
    }

}