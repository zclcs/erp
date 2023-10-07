package com.zclcs.erp.api.bean.ao;

import com.zclcs.erp.core.strategy.ValidGroups;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 订单 Ao
 *
 * @author zclcs
 * @since 2023-09-14 11:36:32.023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrdersAo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     * 默认值：
     */
    @NotNull(message = "{required}", groups = {ValidGroups.Crud.Update.class})
    private Long id;

    /**
     * 公司编号
     * 默认值：
     */
    @NotNull(message = "{required}")
    private Long companyId;

    /**
     * 送货日期
     * 默认值：
     */
    @NotNull(message = "{required}")
    private LocalDate deliveryDate;


}