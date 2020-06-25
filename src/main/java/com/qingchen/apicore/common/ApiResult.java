package com.qingchen.apicore.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * <ClassName>ApiResult</ClassName>
 * <Description></Description>
 */
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = 9211889136173018364L;
    /**
     * 正常响应码
     */
    private static final String SUCCESS_CODE = "0";

    /**
     * 正常响应消息
     */
    private static final String SUCCESS_MSG = "success";

    private String code = SUCCESS_CODE;

    private String traceId;

    private String msg = SUCCESS_MSG;

    private T data = null;

    /**
     * 是否的正常响应
     *
     * @return true=正常；false=异常
     */
    @JsonIgnore
    public boolean isOK() {
        return getCode() == SUCCESS_CODE;
    }

    /**
     * 无data的正常返回
     */
    public static ApiResult retOK() {
        return new ApiResult();
    }

    /**
     * 有data的正常返回
     *
     * @param data data内容
     * @param <T> data类型
     */
    public static <T> ApiResult<T> isOK(T data) {
        ApiResult<T> response = new ApiResult<>();
        response.setData(data);
        return response;
    }

    /**
     * 无data的失败返回
     *
     * @param error 错误类型
     */
    public static ApiResult isFail(BaseEnumError error) {
        return isFail(error.getCode(), error.getMsg());
    }

    public static ApiResult isFail(BizException bizException) {
        return isFail(bizException.getCode(), bizException.getMessage());
    }

    /**
     * 有data的失败返回
     *
     * @param error 错误类型
     * @param data 详细错误信息
     */
    public static <T> ApiResult<T> isFail(BaseEnumError error, T data) {
        return isFail(error.getCode(), error.getMsg(), data);
    }

    /**
     * 无data的失败返回
     *
     * @param code 错误码
     * @param msg 错误信息
     */
    public static <T> ApiResult<T> isFail(String code, String msg) {
        ApiResult<T> response = new ApiResult<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    /**
     * 有data的失败返回
     * <br>
     * 失败返回的场景不多，所以没有严格要求T泛型
     *
     * @param code 错误码
     * @param msg 错误信息
     */
    public static <T> ApiResult<T> isFail(String code, String msg, T data) {
        ApiResult<T> response = new ApiResult<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    /**
     * 错误码
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 错误信息
     */
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 响应内容，默认为null
     */
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
