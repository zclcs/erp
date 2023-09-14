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
 * 公司 Ao
 *
 * @author zclcs
 * @since 2023-09-14 11:36:37.189
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CompanyAo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 公司表主键
     * 默认值：
     */
    @NotNull(message = "{required}", groups = {ValidGroups.Crud.Update.class})
    private Long id;

    /**
     * 公司名称
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