package com.zclcs.erp.api.bean.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 对账单公司
 *
 * @author zclcs
 */
@Entity
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    /**
     * 公司名称
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     * 备注
     */
    @Column(nullable = true, length = 200)
    private String remark;

    /**
     * 级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
     * 拥有mappedBy注解的实体类为关系被维护端
     * mappedBy="company"中的company_id是Bill中的company属性
     */
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bill> billList;


}
