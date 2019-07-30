package com.bosssoft.hr.train.aop;


import com.bosssoft.hr.train.pojo.entity.User;
import com.bosssoft.hr.train.pojo.vo.DictionaryVo;
import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-25
 */
@Aspect
@Configuration
public class ControllerAspect {
    private org.slf4j.Logger logger= LoggerFactory.getLogger(ControllerAspect.class);
    private static final String DICTIONARYVO="dictionaryVo";
    private Gson gson=new Gson();
    /**
     * 指定切点
     * 匹配带有logger的注解的方法
     */
    @Pointcut("execution(public * com.bosssoft.hr.train.controller..*.*(..))")
    public void log(){}


    /**
     * 记录请求URL和请求完成后结果
     * @param joinPoint 切面
     * @return 执行结果
     */
    @Around("log()")
    public Object logProcess(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result=null;
        //获取方法签名
        Object[] args=joinPoint.getArgs();
        if (args!=null){
            for (Object arg:args){
                logger.info("请求为："+arg.toString());
            }
        }
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes!=null){
            HttpServletRequest request=requestAttributes.getRequest();
            logger.info("请求类型为："+request.getMethod()+"  请求目标为："+joinPoint.getTarget().toString()+"  请求URL为："+request.getRequestURL().toString());
            result = joinPoint.proceed();
            logger.info("执行结果："+result.toString());
            //获取用户
            User user=null;
            user= (User) request.getSession().getAttribute("User");
            if (user!=null){
                logger.info("操作者为："+user.getName());
            }
        }
        return result;
    }

}
