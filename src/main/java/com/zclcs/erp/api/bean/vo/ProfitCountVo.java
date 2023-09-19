package com.zclcs.erp.api.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author zclcs
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProfitCountVo {

    /**
     * 统计日期
     */
    private String date;

    /**
     * 进货金额
     */
    private BigDecimal restockAmount = new BigDecimal("0");

    /**
     * 送货金额
     */
    private BigDecimal deliverGoodsAmount = new BigDecimal("0");

    /**
     * 利润
     */
    private BigDecimal profitAmount = new BigDecimal("0");

}
