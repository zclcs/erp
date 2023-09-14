package com.zclcs.erp.controller;

import com.zclcs.erp.api.bean.ao.ProductAo;
import com.zclcs.erp.api.bean.entity.Product;
import com.zclcs.erp.api.bean.vo.ProductVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.core.base.BaseRsp;
import com.zclcs.erp.core.bean.ValidatedList;
import com.zclcs.erp.core.constant.Strings;
import com.zclcs.erp.core.strategy.ValidGroups;
import com.zclcs.erp.service.ProductService;
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
 * 产品
 *
 * @author zclcs
 * @since 2023-09-14 11:36:26.807
 */
@Slf4j
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * 产品查询（分页）
     * 权限: product:page
     *
     * @see ProductService#findProductPage(BasePageAo, ProductVo)
     */
    @GetMapping
    public BaseRsp<BasePage<ProductVo>> findProductPage(@Validated BasePageAo basePageAo, @Validated ProductVo productVo) {
        BasePage<ProductVo> page = this.productService.findProductPage(basePageAo, productVo);
        return RspUtil.data(page);
    }

    /**
     * 产品查询（集合）
     * 权限: product:list
     *
     * @see ProductService#findProductList(ProductVo)
     */
    @GetMapping("/list")
    public BaseRsp<List<ProductVo>> findProductList(@Validated ProductVo productVo) {
        List<ProductVo> list = this.productService.findProductList(productVo);
        return RspUtil.data(list);
    }

    /**
     * 产品查询（单个）
     * 权限: product:one
     *
     * @see ProductService#findProduct(ProductVo)
     */
    @GetMapping("/one")
    public BaseRsp<ProductVo> findProduct(@Validated ProductVo productVo) {
        ProductVo product = this.productService.findProduct(productVo);
        return RspUtil.data(product);
    }

    /**
     * 新增产品
     * 权限: product:add
     *
     * @see ProductService#createProduct(ProductAo)
     */
    @PostMapping
    public BaseRsp<Product> addProduct(@Validated @RequestBody ProductAo productAo) {
        return RspUtil.data(this.productService.createProduct(productAo));
    }

    /**
     * 修改产品
     * 权限: product:update
     *
     * @see ProductService#updateProduct(ProductAo)
     */
    @PutMapping
    public BaseRsp<Product> updateProduct(@Validated({ValidGroups.Crud.Update.class}) @RequestBody ProductAo productAo) {
        return RspUtil.data(this.productService.updateProduct(productAo));
    }

    /**
     * 新增或修改产品
     * 权限: product:createOrUpdate
     *
     * @see ProductService#createOrUpdateProduct(ProductAo)
     */
    @PostMapping("/createOrUpdate")
    public BaseRsp<Product> createOrUpdateProduct(@RequestBody @Validated ProductAo productAo) {
        return RspUtil.data(this.productService.createOrUpdateProduct(productAo));
    }

    /**
     * 删除产品
     * 权限: product:delete
     *
     * @param productIds 产品id集合(,分隔)
     * @see ProductService#deleteProduct(List)
     */
    @DeleteMapping("/{productIds}")
    public BaseRsp<String> deleteProduct(@NotBlank(message = "{required}") @PathVariable String productIds) {
        List<Long> ids = Arrays.stream(productIds.split(Strings.COMMA)).map(Long::valueOf).collect(Collectors.toList());
        this.productService.deleteProduct(ids);
        return RspUtil.message("删除成功");
    }

    /**
     * 批量新增产品
     * 权限: product:add:batch
     *
     * @see ProductService#createProductBatch(List)
     */
    @PostMapping("/batch")
    public BaseRsp<List<Product>> createProductBatch(@RequestBody @Validated ValidatedList<ProductAo> productAos) {
        return RspUtil.data(this.productService.createProductBatch(productAos));
    }

    /**
     * 批量修改产品
     * 权限: product:update:batch
     *
     * @see ProductService#createOrUpdateProductBatch(List)
     */
    @PutMapping("/batch")
    public BaseRsp<List<Product>> updateProductBatch(@RequestBody @Validated({ValidGroups.Crud.Update.class}) ValidatedList<ProductAo> productAos) {
        return RspUtil.data(this.productService.updateProductBatch(productAos));
    }

    /**
     * 批量新增或修改产品
     * id为空则新增，不为空则修改
     * 权限: product:createOrUpdate:batch
     *
     * @see ProductService#createOrUpdateProductBatch(List)
     */
    @PostMapping("/createOrUpdate/batch")
    public BaseRsp<List<Product>> createOrUpdateProductBatch(@RequestBody @Validated ValidatedList<ProductAo> productAos) {
        return RspUtil.data(this.productService.createOrUpdateProductBatch(productAos));
    }

}