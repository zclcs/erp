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
 * 对账单和子订单关联 Entity
 *
 * @author zclcs
 * @since 2023-09-14 11:36:41.197
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table("child_order_bill")
public class ChildOrderBill implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 对账表和子单的关联表
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 子单id
     */
    @Column("child_order_id")
    private Long childOrderId;

    /**
     * 对账单id
     */
    @Column("bill_id")
    private Long billId;


}