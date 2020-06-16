package com.qingchen.apicore.common;

/**
 * <ClassName>BaseEnumError</ClassName>
 * <Description></Description>
 *
 */
public enum  BaseEnumError {
    ERROR("10000","系统异常"),
    OVERTIME("10001","调用超时");



    private String code;
    private String msg;

    private BaseEnumError(String code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}
