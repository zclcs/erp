package com.zclcs.erp.api.bean.ao;

import com.zclcs.erp.core.strategy.ValidGroups;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 进货单 Ao
 *
 * @author zclcs
 * @since 2023-09-14 11:36:17.891
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PurchaseAo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * 默认值：
     */
    @NotNull(message = "{required}", groups = {ValidGroups.Crud.Update.class})
    private Long id;

    /**
     * 进货公司id
     * 默认值：
     */
    private Long productCompanyId;

    /**
     * 进货日期
     * 默认值：
     */
    private LocalDate purchaseDate;

    /**
     * 进货金额
     * 默认值：
     */
    private BigDecimal purchaseAmount;


}