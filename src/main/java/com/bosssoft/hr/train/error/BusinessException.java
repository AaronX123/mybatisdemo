package com.bosssoft.hr.train.error;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-25
 */
public class BusinessException extends Exception implements CommonError{
    CommonError commonError;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    public BusinessException(CommonError commonError,String errorMessage){
        super();
        this.commonError=commonError;
        this.commonError.setErrorMessage(errorMessage);
    }
    /**
     * 获取ErrorCode
     *
     * @return errorCode
     */
    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    /**
     * 获取errorMassage
     *
     * @return errorMsg
     */
    @Override
    public String getErrorMessage() {
        return this.commonError.getErrorMessage();
    }

    /**
     * 设置errorMassage
     *
     * @param errorMsg 错误信息
     * @return 通用返回类型
     */
    @Override
    public CommonError setErrorMessage(String errorMsg) {
        this.commonError.setErrorMessage(errorMsg);
        return this;
    }
}
