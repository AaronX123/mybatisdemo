package com.bosssoft.hr.train.aop;

import com.bosssoft.hr.train.error.BusinessException;
import com.bosssoft.hr.train.error.EnumBusinessError;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-26
 */
@Aspect
@Configuration
public class ParamValidateAspect {
    @Pointcut("execution(public * com.bosssoft.hr.train.controller..*.*(..))")
    public void validate(){};

    @Before("validate()")
    public void validateParam(JoinPoint joinPoint) throws Throwable {
        Object[] args=joinPoint.getArgs();
        if (args!=null){
            for (Object arg:args){
                if (arg==null){
                    throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
                }
            }
        }
    }

}
