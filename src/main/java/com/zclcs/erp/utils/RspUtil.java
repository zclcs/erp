package com.zclcs.erp.utils;

import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BaseRsp;
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

    public <T> BaseRsp<T> message() {
        return new BaseRsp<>();
    }

    public <T> BaseRsp<T> page(BasePage<T> page) {
        return new BaseRsp<>(page);
    }

    public <T> BaseRsp<T> data(T data) {
        return new BaseRsp<>(data);
    }

    public <T> BaseRsp<T> message(String msg, BasePage<T> page) {
        return new BaseRsp<>(msg, page);
    }

    /**
     * 成功消息
     *
     * @param message 消息体
     * @return 返回json
     */
    public <T> BaseRsp<T> message(String message) {
        return new BaseRsp<>(message);
    }

    public <T> BaseRsp<T> error(Integer code, String message) {
        return new BaseRsp<>(code, message);
    }

}
