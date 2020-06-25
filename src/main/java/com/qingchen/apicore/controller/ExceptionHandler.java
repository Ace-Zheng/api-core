package com.qingchen.apicore.controller;

import com.qingchen.apicore.common.ApiResult;
import com.qingchen.apicore.common.BaseEnumError;
import com.qingchen.apicore.common.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <ClassName>ExceptionHandler</ClassName>
 *
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value =Exception.class)
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
