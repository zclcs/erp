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
import java.time.LocalDate;

/**
 * 订单 Entity
 *
 * @author zclcs
 * @since 2023-09-14 11:36:32.023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table("orders")
public class Orders implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 公司编号
     */
    @Column("company_id")
    private Long companyId;

    /**
     * 公司名称
     */
    @Column("company_name")
    private String companyName;

    /**
     * 送货日期
     */
    @Column("delivery_date")
    private LocalDate deliveryDate;

    /**
     * 状态 1 有效 0 删除
     */
    @Column("orders_status")
    private Integer ordersStatus;


}