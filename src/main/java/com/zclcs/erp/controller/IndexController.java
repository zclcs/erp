package com.zclcs.erp.controller;

import com.zclcs.erp.utils.RspUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zclcs
 */
@RestController
public class IndexController {

    @GetMapping("index")
    public ModelAndView index() {
        return RspUtil.jumpPage("index");
    }

    @GetMapping("welcome")
    public ModelAndView welcome() {
        return RspUtil.jumpPage("welcome/welcome-1");
    }

    @GetMapping("system/company")
    public ModelAndView company() {
        return RspUtil.jumpPage("system/company/table");
    }

}
