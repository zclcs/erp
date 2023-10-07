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
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 进货单 Entity
 *
 * @author zclcs
 * @since 2023-09-14 11:36:17.891
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table("purchase")
public class Purchase implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 进货公司id
     */
    @Column("product_company_id")
    private Long productCompanyId;

    /**
     * 进货日期
     */
    @Column("purchase_date")
    private LocalDate purchaseDate;

    /**
     * 进货金额
     */
    @Column("purchase_amount")
    private BigDecimal purchaseAmount;


}