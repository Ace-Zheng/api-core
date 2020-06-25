package com.qingchen.apicore.controller;

import com.qingchen.apicore.common.ApiResult;
import com.qingchen.apicore.common.BaseEnumError;
import com.qingchen.apicore.common.BizException;
import com.qingchen.apicore.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <ClassName>DemoController</ClassName>
 *
 */
@RequestMapping("/api/1.0/")
@CrossOrigin
@Slf4j
public class BaseController {

    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ApiResult exceptionHandler(HttpServletRequest req, Exception e){
        if (e instanceof BizException) {
            BizException bizException  = (BizException)e;
            log.error("BizException:",e);
            return ApiResult.isFail(bizException);
        }else {
            log.error("未知异常！原因是:",e);
            return ApiResult.isFail(BaseEnumError.ERROR);
        }
    }
}
