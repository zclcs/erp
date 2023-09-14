package com.zclcs.erp.api.bean.ao;

import com.zclcs.erp.core.strategy.ValidGroups;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 进货公司 Ao
 *
 * @author zclcs
 * @since 2023-09-14 11:36:22.587
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProductCompanyAo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 进货公司编号
     * 默认值：
     */
    @NotNull(message = "{required}", groups = {ValidGroups.Crud.Update.class})
    private Long id;

    /**
     * 进货公司名称
     * 默认值：
     */
    @Size(max = 255, message = "{noMoreThan}")
    @NotBlank(message = "{required}")
    private String name;

    /**
     * 备注
     * 默认值：
     */
    @Size(max = 255, message = "{noMoreThan}")
    private String remark;


}