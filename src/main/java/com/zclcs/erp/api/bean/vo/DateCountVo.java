package com.zclcs.erp.api.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zclcs
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DateCountVo {

    private Date date;

    private BigDecimal totalAmount = new BigDecimal("0");

}
