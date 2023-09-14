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

/**
 * 子订单 Entity
 *
 * @author zclcs
 * @since 2023-09-14 11:36:04.813
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table("child_order")
public class ChildOrder implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 子订单编号
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 父订单编号
     */
    @Column("orders_id")
    private Long ordersId;

    /**
     * 子产品编号
     */
    @Column("product_id")
    private Long productId;

    /**
     * 子产品名称
     */
    @Column("product_name")
    private String productName;

    /**
     * 规格型号/桶
     */
    @Column("specification")
    private Integer specification;

    /**
     * 桶数
     */
    @Column("number")
    private Integer number;

    /**
     * 重量
     */
    @Column("weight")
    private Integer weight;

    /**
     * 单价
     */
    @Column("price")
    private BigDecimal price;

    /**
     * 金额
     */
    @Column("amount")
    private BigDecimal amount;

    /**
     * 备注
     */
    @Column("remark")
    private String remark;

    /**
     * 状态 1 有效 0 删除
     */
    @Column("child_order_status")
    private Integer childOrderStatus;


}