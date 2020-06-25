package com.qingchen.apicore.config;

import brave.Tracer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qingchen.apicore.common.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;


@Aspect   //定义一个切面
@Configuration
@Slf4j
public class TraceAspect {

    // 定义切点Pointcut
    @Pointcut("execution(* com.qingchen.apicore.controller..*.*(..))")
    public void excudeService() {
    }

    @Autowired
    Tracer tracer;

    @Around("excudeService()")
    public ApiResult doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        log.info("Api begin--url:{}, method:{}, uri:{}, params:d{}", url, method, uri, queryString);
        // result的值就是被拦截方法的返回值
        ApiResult result = (ApiResult) pjp.proceed();
        result.setTraceId(tracer.currentSpan().context().traceIdString());
        log.info("Api Result-- {}", JSONObject.toJSONString(result));
        return result;
    }
}