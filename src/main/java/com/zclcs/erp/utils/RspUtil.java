package com.zclcs.erp.utils;

import com.zclcs.erp.api.base.BaseRsp;
import lombok.experimental.UtilityClass;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zclcs
 */
@UtilityClass
public class RspUtil {

    /**
     * 页面跳转
     */
    public ModelAndView jumpPage(String path) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(path);
        return modelAndView;
    }

    /**
     * 成功不带参
     *
     * @return 返回json
     */
    public <T> BaseRsp<T> message() {
        return new BaseRsp<T>().setMsg("调用成功");
    }

    /**
     * 调用成功 - 消息体
     *
     * @param data 数据体
     * @return 返回json
     */
    public <T> BaseRsp<T> message(T data) {
        BaseRsp<T> vo = new BaseRsp<>();
        vo.setData(data);
        return vo;
    }

    /**
     * 调用成功 - 消息体
     *
     * @param data 数据体
     * @return 返回json
     */
    public <T> BaseRsp<T> message(String msg, T data) {
        BaseRsp<T> vo = new BaseRsp<>();
        vo.setMsg(msg);
        vo.setData(data);
        return vo;
    }

    /**
     * 成功消息
     *
     * @param message 消息体
     * @return 返回json
     */
    public <T> BaseRsp<T> message(String message) {
        BaseRsp<T> vo = new BaseRsp<>();
        vo.setMsg(message);
        return vo;
    }

    /**
     * 调用成功 - 返回数据
     *
     * @param data 数据
     * @return 返回json
     */
    public <T> BaseRsp<T> data(T data) {
        BaseRsp<T> vo = new BaseRsp<>();
        vo.setData(data);
        return vo;
    }
}
