package com.bosssoft.hr.train.service.impl;

import com.bosssoft.hr.train.aop.LogService;
import com.bosssoft.hr.train.error.BusinessException;
import com.bosssoft.hr.train.error.EnumBusinessError;
import com.bosssoft.hr.train.mapper.UserMapper;
import com.bosssoft.hr.train.pojo.dto.UserDto;
import com.bosssoft.hr.train.pojo.entity.User;
import com.bosssoft.hr.train.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    /**
     * 用户登录
     *
     * @param username     用户账号
     * @param password 用户密码
     * @return 登录成功的用户信息
     */
    @LogService
    @Override
    public User login(String username, String password) throws BusinessException {
        if (username==null||password==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Example example=new Example(UserDto.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("name",username);
        criteria.andEqualTo("password",password);
        //此处传example
        List<UserDto> list=mapper.selectByExample(example);

        if (list==null||list.size()<=0){
            throw new BusinessException(EnumBusinessError.DATA_NOTEXSIST.setErrorMessage("用户名或密码错误"));
        }
        UserDto userDto=list.get(0);
        return convertUserFromUserDto(userDto);
    }
    /**
     * 插入用户
     * @param user 用户
     * @return 成功为true否则为false
     */
    @Override
    @Transactional(rollbackForClassName = {"Exception.class"})
    public boolean insert(User user) throws BusinessException {
        UserDto userDto=convertUserDtoFromUser(user);
        if (userDto==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        return mapper.insertSelective(userDto)>0;
    }


    /**
     * 通过id查询用户
     *
     * @param id id
     * @return 查询到的用户
     */
    @LogService
    @Override
    public User queryUserById(Long id) throws BusinessException {
        UserDto userDto=mapper.selectByPrimaryKey(id);
        if (userDto==null){
            throw new BusinessException(EnumBusinessError.DATA_NOTEXSIST.setErrorMessage("该用户不存在"));
        }
        return convertUserFromUserDto(userDto);
    }

    /**
     * 更新用户
     *
     * @param user 更新的用户属性
     * @return 更新成功返回true否则false
     */
    @LogService
    @Override
    @Transactional(rollbackForClassName = {"Exception.class"})
    public boolean update(User user) throws BusinessException {
        UserDto userDto=convertUserDtoFromUser(user);
        if (userDto==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        return mapper.updateByPrimaryKeySelective(userDto)>0;
    }

    /**
     * 删除用户通过id
     *
     * @param id 用户Id
     * @return 删除成功返回true否则false
     */
    @LogService
    @Override
    @Transactional(rollbackForClassName = {"Exception.class"})
    public boolean deleteUserById(Long id) throws BusinessException {
        if (id==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        return mapper.deleteByPrimaryKey(id)>0;
    }

    /**
     * 删除用户
     *
     * @param user 要删除的用户信息
     * @return 删除成功返回true否则false
     */
    @LogService
    @Override
    @Transactional(rollbackForClassName = {"Exception.class"})
    public boolean deleteUser(User user) throws BusinessException {
        if (user==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        UserDto userDto=convertUserDtoFromUser(user);
        return mapper.delete(userDto)>0;
    }

    private User convertUserFromUserDto(UserDto userDto){
        User user=new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
    private UserDto convertUserDtoFromUser(User user){
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}
