package com.bosssoft.hr.train.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-25
 */
@Aspect
@Configuration
public class LogServiceAspect {
    private Logger logger= LoggerFactory.getLogger(LogServiceAspect.class);
    @Pointcut("execution(public * com.bosssoft.hr.train.service..*.*(..))")
    public void logService(){}

//    @Before("logService()")
//    public void logDBOperation(JoinPoint joinPoint){
//        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        logger.info(servletRequestAttributes.getRequest().toString());
//    }
}
