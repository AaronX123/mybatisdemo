package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.error.BusinessException;
import com.bosssoft.hr.train.pojo.entity.User;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-25
 */
public interface UserService {
    /**
     * 用户登录
     * @param code 用户账号
     * @param password 用户密码
     * @return 登录成功的用户信息
     */
    User login(String code, String password) throws BusinessException;

    /**
     * 插入用户
     * @param user 用户
     * @return 成功为true否则为false
     */
    boolean insert(User user) throws BusinessException;
    /**
     * 通过id查询用户
    * @param id id
     * @return 查询到的用户
     */
    User queryUserById(Long id) throws BusinessException;

    /**
     * 更新用户
     * @param user 更新的用户属性
     * @return 更新成功返回true否则false
     */
    boolean update(User user) throws BusinessException;

    /**
     * 删除用户通过id
     * @param id 用户Id
     * @return 删除成功返回true否则false
     */
    boolean deleteUserById(Long id) throws BusinessException;

    /**
     * 删除用户
     * @param user 要删除的用户信息
     * @return 删除成功返回true否则false
     */
    boolean deleteUser(User user) throws BusinessException;
}
