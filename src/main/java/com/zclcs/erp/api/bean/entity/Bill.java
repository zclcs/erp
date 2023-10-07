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
 * 对账单 Entity
 *
 * @author zclcs
 * @since 2023-09-14 11:36:09.432
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table("bill")
public class Bill implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 对账表编号
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 公司编号
     */
    @Column("company_id")
    private Long companyId;

    /**
     * 对账单生成日期
     */
    @Column("delivery_date")
    private String deliveryDate;

    /**
     * 对账单名称
     */
    @Column("name")
    private String name;


}