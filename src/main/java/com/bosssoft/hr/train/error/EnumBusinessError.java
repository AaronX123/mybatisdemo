package com.bosssoft.hr.train.error;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-25
 */
public enum EnumBusinessError implements CommonError {
    /**
     * 通用参数错误类型100001
     */
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),

    SNOWFLAKE_GENERATE_ERROR(10005,"id生成失败"),
    /**
     *
     */
    DATA_NOTEXSIST(20001,"该数据不存在"),
    UNKNOW_ERROR(10002,"未知错误"),
    ;

    private int errorCode;
    private String errorMessage;
    EnumBusinessError(int errorCode,String errorMessage){
        this.errorCode=errorCode;
        this.errorMessage =errorMessage;
    }
    /**
     * 获取ErrorCode
     *
     * @return errorCode
     */
    @Override
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * 获取errorMassage
     *
     * @return errorMsg
     */
    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 设置errorMassage
     *
     * @param errorMsg 错误信息
     * @return 通用返回类型
     */
    @Override
    public CommonError setErrorMessage(String errorMsg) {
        this.errorMessage=errorMsg;
        return this;
    }
}
