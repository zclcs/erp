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
 * 系统配置 Vo
 *
 * @author zclcs
 * @since 2023-09-14 11:36:13.675
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SystemConfigVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统配置id
     * 默认值：
     */
    private Long id;

    /**
     * 业务员
     * 默认值：
     */
    private String salesman;

    /**
     * 联系电话
     * 默认值：
     */
    private String phone;

    /**
     * 公司名
     * 默认值：
     */
    private String title;


}