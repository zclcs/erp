package com.zclcs.erp.api.bean.ao;

import com.zclcs.erp.core.strategy.ValidGroups;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 系统配置 Ao
 *
 * @author zclcs
 * @since 2023-09-14 11:36:13.675
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SystemConfigAo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统配置id
     * 默认值：
     */
    @NotNull(message = "{required}", groups = {ValidGroups.Crud.Update.class})
    private Long id;

    /**
     * 业务员
     * 默认值：
     */
    @Size(max = 255, message = "{noMoreThan}")
    private String salesman;

    /**
     * 联系电话
     * 默认值：
     */
    @Size(max = 20, message = "{noMoreThan}")
    private String phone;

    /**
     * 公司名
     * 默认值：
     */
    @Size(max = 255, message = "{noMoreThan}")
    private String title;


}