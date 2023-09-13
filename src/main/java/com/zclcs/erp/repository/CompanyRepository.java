package com.zclcs.erp.repository;

import com.zclcs.erp.api.bean.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zclcs
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {

    /**
     * 根据名称查找
     *
     * @param name 名称
     * @return {@link Company}
     */
    List<Company> findByName(@Param("name") String name);

}
