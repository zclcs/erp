package com.zclcs.erp.api.bean.vo;

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
     * 状态 1 有效 0 删除
     * 默认值：
     */
    private Integer ordersStatus;


}