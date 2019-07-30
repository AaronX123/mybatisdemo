package com.bosssoft.hr.train.service.impl;

import com.bosssoft.hr.train.error.BusinessException;
import com.bosssoft.hr.train.pojo.entity.User;
import com.bosssoft.hr.train.service.CommonService;
import com.bosssoft.hr.train.snowflake.SnowFlake;
import com.bosssoft.hr.train.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-27
 */

@Service
public class CommonServieImpl implements CommonService {
    @Autowired
    RedisUtil redisUtil;
    /**
     * 雪花算法中5位计算机标志
     */
    private int workerId=1;
    /**
     * 5位数据中心标志
     */
    private int dataCenterId=1;
    /**
     * 雪花算法类
     */
    private SnowFlake snowFlake=new SnowFlake(workerId,dataCenterId);
    /**
     * 使用雪花算法生成id
     *
     * @return 运算出来的id
     */
    @Override
    public long generateId() throws BusinessException {
        return snowFlake.nextId();
    }

    /**
     * 获取当前系统使用者姓名
     *
     * @return username
     */
    @Override
    public String getUserName() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String username="Aaron22";
        if (requestAttributes!=null){
            HttpSession session=requestAttributes.getRequest().getSession();
            username= (String) session.getAttribute("username");
        }
        //String defaultname="Aaron";
        return username;
    }

    /**
     * 获取当前时间
     * @return currentDate
     */
    @Override
    public Date getDate() {
        return new Date();
    }

    /**
     * 记录用户登陆信息
     *
     * @param user 登陆的用户
     */
    @Override
    public void saveUserRecord(User user) {
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes!=null){
            HttpSession session=requestAttributes.getRequest().getSession();
            session.setAttribute("username",user.getName());
        }
    }


}
