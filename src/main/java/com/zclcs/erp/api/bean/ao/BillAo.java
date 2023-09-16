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
 * 对账单 Ao
 *
 * @author zclcs
 * @since 2023-09-14 11:36:09.432
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BillAo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 对账表编号
     * 默认值：
     */
    @NotNull(message = "{required}", groups = {ValidGroups.Crud.Update.class})
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
    @Size(max = 255, message = "{noMoreThan}")
    private String companyName;

    /**
     * 对账单生成日期
     * 默认值：
     */
    @Size(max = 10, message = "{noMoreThan}")
    private String deliveryDate;

    /**
     * 对账单名称
     * 默认值：
     */
    @Size(max = 255, message = "{noMoreThan}")
    private String name;

    /**
     * 总金额
     * 默认值：
     */
    private BigDecimal totalAmount;

    /**
     * 对账日期-月份
     */
    @NotBlank(message = "{required}", groups = {ValidGroups.Crud.Create.class})
    private String deliveryDateMonth;


}