package com.zclcs.erp.api.bean.ao;

import com.zclcs.erp.core.strategy.ValidGroups;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 对账单和子订单关联 Ao
 *
 * @author zclcs
 * @since 2023-09-14 11:36:41.197
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ChildOrderBillAo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 对账表和子单的关联表
     * 默认值：
     */
    @NotNull(message = "{required}", groups = {ValidGroups.Crud.Update.class})
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