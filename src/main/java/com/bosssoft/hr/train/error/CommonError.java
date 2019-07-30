package com.bosssoft.hr.train.error;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-25
 */
public interface CommonError {
    /**
     * 获取ErrorCode
     * @return errorCode
     */
    public int getErrorCode();

    /**
     * 获取errorMassage
     * @return errorMsg
     */
    public String getErrorMessage();

    /**
     * 设置errorMassage
     * @param errorMsg 错误信息
     * @return 通用返回类型
     */
    public CommonError setErrorMessage(String errorMsg);
}
