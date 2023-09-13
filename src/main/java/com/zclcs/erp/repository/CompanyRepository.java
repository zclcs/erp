package com.zclcs.erp.repository;

import com.zclcs.erp.api.bean.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author zclcs
 */
@RepositoryRestResource(collectionResourceRel = "company", path = "company")
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long>, CrudRepository<Company, Long> {

    /**
     * 根据名称查找
     *
     * @param name 名称
     * @return {@link Company}
     */
    List<Company> findByName(@Param("name") String name);

}
