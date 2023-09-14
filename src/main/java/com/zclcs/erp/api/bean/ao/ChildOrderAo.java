package com.zclcs.erp.api.bean.ao;

import com.zclcs.erp.core.strategy.ValidGroups;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 子订单 Ao
 *
 * @author zclcs
 * @since 2023-09-14 11:36:04.813
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ChildOrderAo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 子订单编号
     * 默认值：
     */
    @NotNull(message = "{required}", groups = {ValidGroups.Crud.Update.class})
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
    @NotNull(message = "{required}")
    private Long productId;

    /**
     * 子产品名称
     * 默认值：
     */
    @Size(max = 255, message = "{noMoreThan}")
    @NotBlank(message = "{required}")
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
    @Size(max = 255, message = "{noMoreThan}")
    private String remark;

    /**
     * 状态 1 有效 0 删除
     * 默认值：
     */
    @NotNull(message = "{required}")
    private Integer childOrderStatus;


}