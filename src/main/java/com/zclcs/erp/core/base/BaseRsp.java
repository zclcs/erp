package com.zclcs.erp.core.base;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * 消息响应格式
 *
 * @author zclcs
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaseRsp<T> {

    /**
     * 响应code
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应单个
     */
    private T bean;

    /**
     * 统计数量
     */
    private Long count;

    /**
     * 数据集合
     */
    private List<T> data;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 统计
     */
    private Map<String, Object> totalRow;

    public BaseRsp() {
        this.code = 0;
        this.msg = "调用成功";
    }

    public BaseRsp(String msg) {
        this();
        this.msg = msg;
    }

    public BaseRsp(Integer code, String msg) {
        this();
        this.code = code;
        this.msg = msg;
    }

    public BaseRsp(T bean) {
        this();
        this.bean = bean;
    }

    public BaseRsp(BasePage<T> page) {
        this();
        this.data = page.getList();
        this.count = page.getTotal();
    }

    public BaseRsp(BasePage<T> page, Map<String, Object> totalRow) {
        this();
        this.data = page.getList();
        this.count = page.getTotal();
        this.totalRow = totalRow;
    }

    public BaseRsp(String msg, BasePage<T> page) {
        this(msg);
        this.data = page.getList();
        this.count = page.getTotal();
    }

    public boolean isSuccess() {
        return this.code == 0;
    }
}
