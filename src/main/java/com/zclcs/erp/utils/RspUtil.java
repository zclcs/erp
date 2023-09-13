package com.zclcs.erp.utils;

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
}
