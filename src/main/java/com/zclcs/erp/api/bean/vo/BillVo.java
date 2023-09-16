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

/**
 * 对账单 Vo
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
public class BillVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 对账表编号
     * 默认值：
     */
    private Long id;

    /**
     * 公司编号
     * 默认值：
     */
    private Long companyId;

    /**
     * 公司名称
     * 默认值：
     */
    private String companyName;

    /**
     * 对账单生成日期
     * 默认值：
     */
    private String deliveryDate;

    /**
     * 对账单名称
     * 默认值：
     */
    private String name;

    /**
     * 总金额
     * 默认值：
     */
    private BigDecimal totalAmount;

    /**
     * 对账日期-月份
     */
    private String deliveryDateMonth;

    public BigDecimal getTotalAmount() {
        return this.totalAmount = totalAmount == null ? new BigDecimal("0") : totalAmount;
    }
}