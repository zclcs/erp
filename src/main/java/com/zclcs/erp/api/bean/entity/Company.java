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
 * 公司 Entity
 *
 * @author zclcs
 * @since 2023-09-14 11:36:37.189
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table("company")
public class Company implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 公司表主键
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 公司名称
     */
    @Column("name")
    private String name;

    /**
     * 备注
     */
    @Column("remark")
    private String remark;


}