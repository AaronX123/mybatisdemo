package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.error.BusinessException;
import com.bosssoft.hr.train.error.EnumBusinessError;
import com.bosssoft.hr.train.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于处理异常
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-25
 */

public class ExceptionController {
    /**
     * 定义一个通用异常吸收类
     * @param request HttpServletRequest
     * @param exception 执行中任意异常
     * @return 通用返回类型
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonResponse handlerException(HttpServletRequest request, Exception exception){
        Map<String,Object> responseDataMap=new HashMap<>(16);
        if (exception instanceof BusinessException){
            BusinessException businessException= (BusinessException) exception;
            responseDataMap.put("errorCode",businessException.getErrorCode());
            responseDataMap.put("errorMessage",businessException.getErrorMessage());
        }else {
            responseDataMap.put("errorCode", EnumBusinessError.UNKNOW_ERROR.getErrorCode());
            responseDataMap.put("errorMessage",EnumBusinessError.UNKNOW_ERROR.getErrorMessage());
        }
        return CommonResponse.create(responseDataMap,"fail");
    }
}
