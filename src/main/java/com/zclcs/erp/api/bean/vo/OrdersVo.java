package com.zclcs.erp.api.bean.vo;

import cn.hutool.core.util.StrUtil;
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
import java.util.ArrayList;
import java.util.List;

/**
 * 订单 Vo
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
public class OrdersVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
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
     * 送货日期
     * 默认值：
     */
    private LocalDate deliveryDate;

    /**
     * 送货日期-月份-前端条件
     */
    private String deliveryDateMonth;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    public BigDecimal getTotalAmount() {
        return this.totalAmount = totalAmount == null ? new BigDecimal("0") : totalAmount;
    }

    /**
     * 所有子订单id
     */
    private String totalChildOrderId;

    public List<Long> getTotalChildOrderId() {
        return StrUtil.isNotBlank(totalChildOrderId) ? StrUtil.split(totalChildOrderId, StrUtil.COMMA).stream().map(Long::valueOf).toList() : new ArrayList<>();
    }
}