package com.zclcs.erp.controller;

import com.zclcs.erp.api.base.BasePage;
import com.zclcs.erp.api.base.BasePageAo;
import com.zclcs.erp.api.base.BaseRsp;
import com.zclcs.erp.api.bean.entity.Company;
import com.zclcs.erp.service.CompanyService;
import com.zclcs.erp.utils.RspUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对账单公司
 *
 * @author zclcs
 * @since 2023-01-10 10:39:28.842
 */
@Slf4j
@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    /**
     * 对账单公司查询（分页）
     *
     * @see CompanyService#page(BasePageAo)
     */
    @GetMapping("/page")
    public BaseRsp<BasePage<Company>> findCompanyPage(@Validated BasePageAo basePageAo) {
        BasePage<Company> page = this.companyService.page(basePageAo);
        return RspUtil.data(page);
    }
}
