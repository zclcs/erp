package com.zclcs.erp.service;

import com.zclcs.erp.api.base.BasePage;
import com.zclcs.erp.api.base.BasePageAo;
import com.zclcs.erp.api.bean.entity.Company;
import com.zclcs.erp.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author zhouc
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public BasePage<Company> page(BasePageAo basePageAo) {
        Page<Company> all = companyRepository.findAll(basePageAo.pageRequest());
        return new BasePage<>(all);
    }

}
