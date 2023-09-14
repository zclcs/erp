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
 * 进货公司 Vo
 *
 * @author zclcs
 * @since 2023-09-14 11:36:22.587
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProductCompanyVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 进货公司编号
     * 默认值：
     */
    private Long id;

    /**
     * 进货公司名称
     * 默认值：
     */
    private String name;

    /**
     * 备注
     * 默认值：
     */
    private String remark;


}