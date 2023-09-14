package com.zclcs.erp.api.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

/**
 * 对账单和子订单关联 Vo
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
public class ChildOrderBillVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 对账表和子单的关联表
     * 默认值：
     */
    private Long id;

    /**
     * 子单id
     * 默认值：
     */
    private Long childOrderId;

    /**
     * 对账单id
     * 默认值：
     */
    private Long billId;


}