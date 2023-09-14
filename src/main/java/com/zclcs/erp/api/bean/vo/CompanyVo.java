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
 * 公司 Vo
 *
 * @author zclcs
 * @since 2023-09-14 11:36:37.189
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CompanyVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 公司表主键
     * 默认值：
     */
    private Long id;

    /**
     * 公司名称
     * 默认值：
     */
    private String name;

    /**
     * 备注
     * 默认值：
     */
    private String remark;


}