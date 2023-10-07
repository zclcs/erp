package com.zclcs.erp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.If;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.zclcs.erp.api.bean.ao.CompanyAo;
import com.zclcs.erp.api.bean.entity.Company;
import com.zclcs.erp.api.bean.vo.CompanyVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.exception.FieldException;
import com.zclcs.erp.mapper.BillMapper;
import com.zclcs.erp.mapper.CompanyMapper;
import com.zclcs.erp.mapper.OrdersMapper;
import com.zclcs.erp.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.zclcs.erp.api.bean.entity.table.BillTableDef.BILL;
import static com.zclcs.erp.api.bean.entity.table.CompanyTableDef.COMPANY;
import static com.zclcs.erp.api.bean.entity.table.OrdersTableDef.ORDERS;

/**
 * 公司 Service实现
 *
 * @author zclcs
 * @since 2023-09-14 11:36:37.189
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    private final BillMapper billMapper;
    private final OrdersMapper ordersMapper;

    @Override
    public BasePage<CompanyVo> findCompanyPage(BasePageAo basePageAo, CompanyVo companyVo) {
        QueryWrapper queryWrapper = getQueryWrapper(companyVo);
        Page<CompanyVo> page = this.mapper.paginateAs(basePageAo.getPage(), basePageAo.getLimit(), queryWrapper, CompanyVo.class);
        return new BasePage<>(page);
    }

    @Override
    public List<CompanyVo> findCompanyList(CompanyVo companyVo) {
        QueryWrapper queryWrapper = getQueryWrapper(companyVo);
        return this.mapper.selectListByQueryAs(queryWrapper, CompanyVo.class);
    }

    @Override
    public CompanyVo findCompany(CompanyVo companyVo) {
        QueryWrapper queryWrapper = getQueryWrapper(companyVo);
        return this.mapper.selectOneByQueryAs(queryWrapper, CompanyVo.class);
    }

    @Override
    public Long countCompany(CompanyVo companyVo) {
        QueryWrapper queryWrapper = getQueryWrapper(companyVo);
        return this.mapper.selectCountByQuery(queryWrapper);
    }

    private QueryWrapper getQueryWrapper(CompanyVo companyVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(
                        COMPANY.ID,
                        COMPANY.NAME,
                        COMPANY.REMARK
                )
                .where(COMPANY.NAME.like(companyVo.getName(), If::hasText))
                .orderBy(COMPANY.ID.desc())
        ;
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Company createCompany(CompanyAo companyAo) {
        validateCompanyName(companyAo.getName(), companyAo.getId());
        Company company = new Company();
        BeanUtil.copyProperties(companyAo, company);
        this.save(company);
        return company;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Company updateCompany(CompanyAo companyAo) {
        validateCompanyName(companyAo.getName(), companyAo.getId());
        Company company = new Company();
        BeanUtil.copyProperties(companyAo, company);
        this.updateById(company);
        return company;
    }

    @Override
    public Company createOrUpdateCompany(CompanyAo companyAo) {
        Company company = new Company();
        BeanUtil.copyProperties(companyAo, company);
        this.saveOrUpdate(company);
        return company;
    }

    @Override
    public List<Company> createCompanyBatch(List<CompanyAo> companyAos) {
        List<Company> companyList = new ArrayList<>();
        for (CompanyAo companyAo : companyAos) {
            Company company = new Company();
            BeanUtil.copyProperties(companyAo, company);
            companyList.add(company);
        }
        saveBatch(companyList);
        return companyList;
    }

    @Override
    public List<Company> updateCompanyBatch(List<CompanyAo> companyAos) {
        List<Company> companyList = new ArrayList<>();
        for (CompanyAo companyAo : companyAos) {
            Company company = new Company();
            BeanUtil.copyProperties(companyAo, company);
            companyList.add(company);
        }
        updateBatch(companyList);
        return companyList;
    }

    @Override
    public List<Company> createOrUpdateCompanyBatch(List<CompanyAo> companyAos) {
        List<Company> companyList = new ArrayList<>();
        for (CompanyAo companyAo : companyAos) {
            Company company = new Company();
            BeanUtil.copyProperties(companyAo, company);
            companyList.add(company);
        }
        saveOrUpdateBatch(companyList);
        return companyList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCompany(List<Long> ids) {
        if (billMapper.selectCountByQuery(new QueryWrapper().where(BILL.COMPANY_ID.in(ids))) != 0L) {
            throw new FieldException("该公司已生成对账单，不能删除，请删除对应对账单之后再操作");
        }
        if (ordersMapper.selectCountByQuery(new QueryWrapper().where(ORDERS.COMPANY_ID.in(ids))) != 0L) {
            throw new FieldException("该公司已创建订单，不能删除，请删除对应订单之后再操作");
        }
        this.removeByIds(ids);
    }

    @Override
    public void validateCompanyName(String name, Long id) {
        Company one = this.getOne(new QueryWrapper().where(COMPANY.NAME.eq(name)));
        if (one != null && !one.getId().equals(id)) {
            throw new FieldException("公司名称重复");
        }
    }

}
