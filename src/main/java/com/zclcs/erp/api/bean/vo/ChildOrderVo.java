package com.zclcs.erp.api.bean.vo;

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
 * 子订单 Vo
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
public class ChildOrderVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 子订单编号
     * 默认值：
     */
    private Long id;

    /**
     * 父订单编号
     * 默认值：
     */
    private Long ordersId;

    /**
     * 子产品编号
     * 默认值：
     */
    private Long productId;

    /**
     * 子产品名称
     * 默认值：
     */
    private String productName;

    /**
     * 规格型号/桶
     * 默认值：
     */
    private Integer specification;

    /**
     * 桶数
     * 默认值：
     */
    private Integer number;

    /**
     * 重量
     * 默认值：
     */
    private Integer weight;

    /**
     * 单价
     * 默认值：
     */
    private BigDecimal price;

    /**
     * 金额
     * 默认值：
     */
    private BigDecimal amount;

    /**
     * 备注
     * 默认值：
     */
    private String remark;

    /**
     * 状态 1 有效 0 删除
     * 默认值：
     */
    private Integer childOrderStatus;

    /**
     * kg/桶
     */
    private String specificationString;

    /**
     * kg
     */
    private String weightString;

    /**
     * 对账单id
     */
    private Long billId;

    /**
     * 送货日期
     * 默认值：
     */
    private LocalDate deliveryDateOriginal;

    /**
     * 送货日期
     */
    private String deliveryDate;

    public String getSpecificationString() {
        return this.specification == null ? null : this.specification + "kg/桶";
    }

    public String getWeightString() {
        return this.weight == null ? null : this.weight + "kg";
    }
}