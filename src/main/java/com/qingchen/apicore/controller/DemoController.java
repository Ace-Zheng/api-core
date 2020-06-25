package com.qingchen.apicore.controller;

import com.qingchen.apicore.common.ApiResult;
import com.qingchen.apicore.common.BaseEnumError;
import com.qingchen.apicore.common.BizException;
import com.qingchen.apicore.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <ClassName>DemoController</ClassName>
 *
 */
@Controller
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private DemoService demoService;


    @RequestMapping("/demo")
    @ResponseBody
    public ApiResult demo(){
        return ApiResult.isOK(demoService.getUser());
    }

    @RequestMapping("/demo2")
    @ResponseBody
    public ApiResult demo2(){
        throw new BizException(BaseEnumError.OVERTIME);
    }
}
