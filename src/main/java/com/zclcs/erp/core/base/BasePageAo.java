package com.zclcs.erp.core.base;

import lombok.Data;

/**
 * 分页实体
 *
 * @author zclcs
 */
@Data
public class BasePageAo {

    /**
     * 页数
     */
    private Long page = 1L;

    /**
     * 页码
     */
    private Long limit = 10L;


}
