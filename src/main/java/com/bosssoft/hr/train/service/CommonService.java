package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.error.BusinessException;
import com.bosssoft.hr.train.pojo.entity.User;

import java.util.Date;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-27
 */
public interface CommonService {
    /**
     * 使用雪花算法生成id
     * @return 运算出来的id
     */
    long generateId() throws BusinessException;

    /**
     * 获取当前系统使用者姓名
     * @return username
     */
    String getUserName();

    /**
     * 获取当前时间
     * @return currentDate
     */
    Date getDate();

    /**
     * 记录用户登陆信息
     * @param user 登陆的用户
     */
    void saveUserRecord(User user);


}
