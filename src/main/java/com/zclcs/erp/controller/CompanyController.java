package com.zclcs.erp.controller;

import com.zclcs.erp.api.bean.ao.CompanyAo;
import com.zclcs.erp.api.bean.entity.Company;
import com.zclcs.erp.api.bean.vo.CompanyVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.core.base.BaseRsp;
import com.zclcs.erp.core.bean.ValidatedList;
import com.zclcs.erp.core.constant.Strings;
import com.zclcs.erp.core.strategy.ValidGroups;
import com.zclcs.erp.service.CompanyService;
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
 * 公司
 *
 * @author zclcs
 * @since 2023-09-14 11:36:37.189
 */
@Slf4j
@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    /**
     * 公司查询（分页）
     * 权限: company:page
     *
     * @see CompanyService#findCompanyPage(BasePageAo, CompanyVo)
     */
    @GetMapping
    public BaseRsp<CompanyVo> findCompanyPage(@Validated BasePageAo basePageAo, @Validated CompanyVo companyVo) {
        BasePage<CompanyVo> page = this.companyService.findCompanyPage(basePageAo, companyVo);
        return RspUtil.page(page);
    }

    /**
     * 公司查询（集合）
     * 权限: company:list
     *
     * @see CompanyService#findCompanyList(CompanyVo)
     */
    @GetMapping("/list")
    public BaseRsp<List<CompanyVo>> findCompanyList(@Validated CompanyVo companyVo) {
        List<CompanyVo> list = this.companyService.findCompanyList(companyVo);
        return RspUtil.data(list);
    }

    /**
     * 公司查询（单个）
     * 权限: company:one
     *
     * @see CompanyService#findCompany(CompanyVo)
     */
    @GetMapping("/one")
    public BaseRsp<CompanyVo> findCompany(@Validated CompanyVo companyVo) {
        CompanyVo company = this.companyService.findCompany(companyVo);
        return RspUtil.data(company);
    }

    /**
     * 新增公司
     * 权限: company:add
     *
     * @see CompanyService#createCompany(CompanyAo)
     */
    @PostMapping
    public BaseRsp<Company> addCompany(@Validated @RequestBody CompanyAo companyAo) {
        return RspUtil.data(this.companyService.createCompany(companyAo));
    }

    /**
     * 修改公司
     * 权限: company:update
     *
     * @see CompanyService#updateCompany(CompanyAo)
     */
    @PutMapping
    public BaseRsp<Company> updateCompany(@Validated({ValidGroups.Crud.Update.class}) @RequestBody CompanyAo companyAo) {
        return RspUtil.data(this.companyService.updateCompany(companyAo));
    }

    /**
     * 新增或修改公司
     * 权限: company:createOrUpdate
     *
     * @see CompanyService#createOrUpdateCompany(CompanyAo)
     */
    @PostMapping("/createOrUpdate")
    public BaseRsp<Company> createOrUpdateCompany(@RequestBody @Validated CompanyAo companyAo) {
        return RspUtil.data(this.companyService.createOrUpdateCompany(companyAo));
    }

    /**
     * 删除公司
     * 权限: company:delete
     *
     * @param companyIds 公司id集合(,分隔)
     * @see CompanyService#deleteCompany(List)
     */
    @DeleteMapping("/{companyIds}")
    public BaseRsp<String> deleteCompany(@NotBlank(message = "{required}") @PathVariable String companyIds) {
        List<Long> ids = Arrays.stream(companyIds.split(Strings.COMMA)).map(Long::valueOf).collect(Collectors.toList());
        this.companyService.deleteCompany(ids);
        return RspUtil.message("删除成功");
    }

    /**
     * 批量新增公司
     * 权限: company:add:batch
     *
     * @see CompanyService#createCompanyBatch(List)
     */
    @PostMapping("/batch")
    public BaseRsp<List<Company>> createCompanyBatch(@RequestBody @Validated ValidatedList<CompanyAo> companyAos) {
        return RspUtil.data(this.companyService.createCompanyBatch(companyAos));
    }

    /**
     * 批量修改公司
     * 权限: company:update:batch
     *
     * @see CompanyService#createOrUpdateCompanyBatch(List)
     */
    @PutMapping("/batch")
    public BaseRsp<List<Company>> updateCompanyBatch(@RequestBody @Validated({ValidGroups.Crud.Update.class}) ValidatedList<CompanyAo> companyAos) {
        return RspUtil.data(this.companyService.updateCompanyBatch(companyAos));
    }

    /**
     * 批量新增或修改公司
     * id为空则新增，不为空则修改
     * 权限: company:createOrUpdate:batch
     *
     * @see CompanyService#createOrUpdateCompanyBatch(List)
     */
    @PostMapping("/createOrUpdate/batch")
    public BaseRsp<List<Company>> createOrUpdateCompanyBatch(@RequestBody @Validated ValidatedList<CompanyAo> companyAos) {
        return RspUtil.data(this.companyService.createOrUpdateCompanyBatch(companyAos));
    }

}