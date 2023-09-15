package com.zclcs.erp.core.base;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

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

    private T bean;

    private Long count;

    private List<T> data;

    private boolean success;

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

    public BaseRsp(String msg, BasePage<T> page) {
        this(msg);
        this.data = page.getList();
        this.count = page.getTotal();
    }

    public boolean isSuccess() {
        return this.code == 0;
    }
}
