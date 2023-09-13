package com.zclcs.erp.api.base;

import lombok.Data;
import org.springframework.data.domain.PageRequest;

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
    private int pageNum = 1;

    /**
     * 页码
     */
    private int pageSize = 10;

    public PageRequest pageRequest() {
        return PageRequest.of(pageNum - 1, pageSize);
    }
}
