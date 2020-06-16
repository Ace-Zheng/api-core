package com.qingchen.apicore.common;

/**
 * <ClassName>BizException</ClassName>
 * <Description></Description>
 */
public class BizException extends RuntimeException{
    //注意：spring中，只有RuntimeException才会进行事务回滚，Exception不会进行事务回滚
    private String code;

    public BizException(BaseEnumError resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
