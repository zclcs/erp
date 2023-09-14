package com.zclcs.erp.api.bean.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

/**
 * 进货公司 Entity
 *
 * @author zclcs
 * @since 2023-09-14 11:36:22.587
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table("product_company")
public class ProductCompany implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 进货公司编号
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 进货公司名称
     */
    @Column("name")
    private String name;

    /**
     * 备注
     */
    @Column("remark")
    private String remark;


}