package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.aop.ParamValidate;
import com.bosssoft.hr.train.error.BusinessException;
import com.bosssoft.hr.train.error.EnumBusinessError;
import com.bosssoft.hr.train.pojo.entity.User;
import com.bosssoft.hr.train.pojo.vo.UserLoginVo;
import com.bosssoft.hr.train.pojo.vo.UserVo;
import com.bosssoft.hr.train.request.CommonRequest;
import com.bosssoft.hr.train.response.CommonResponse;
import com.bosssoft.hr.train.service.CommonService;
import com.bosssoft.hr.train.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * CrossOrigin DEFAULT_ALLOW_HEADERS允许跨域传输所有参数，将用于Token放入Header域做session共享的跨域请求
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-25
 */
@RequestMapping("/user")
@Controller
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class UserController extends ExceptionController {
    private Gson gson=new Gson();
    @Autowired
    UserService userService;
    @Autowired
    CommonService commonService;
    @RequestMapping("/get")
    @ResponseBody
    public CommonResponse listUser(@RequestBody CommonRequest request) throws BusinessException {
        Object data=request.getData();
        Long id= Long.getLong(data.toString());
        if (id!=null) {
            User user=userService.queryUserById(id);
            UserVo userVo=convertUserVoFromUser(user);
            return CommonResponse.create(userVo);
        }
        return CommonResponse.create("无此用户","fail");
    }

    @ParamValidate
    @RequestMapping("/login")
    @ResponseBody
    public CommonResponse login(@RequestBody CommonRequest request) throws BusinessException {
        //getData返回的是一个LinkedHashMap，然后通过toString转换成String，而LinkedHashMap的toString方法是输出Entry中key+val
        //通过Gson将其转为指定格式
        String userLoginMsg=  request.getData().toString();
        if (userLoginMsg!=null){
            UserLoginVo userLoginVo=gson.fromJson(userLoginMsg, UserLoginVo.class);
            if (userLoginVo!=null){
                User user=userService.login(userLoginVo.getUsername(),userLoginVo.getPassword());
                //保存用户登陆信息
                commonService.saveUserRecord(user);
                UserVo userVo=convertUserVoFromUser(user);
                return CommonResponse.create(userVo);
            }
        }
        return CommonResponse.create(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public CommonResponse logOut(){
        return CommonResponse.create("用户已退出");
    }
    private UserVo convertUserVoFromUser(User user){
        UserVo userVo=new UserVo();
        if (user!=null){
            BeanUtils.copyProperties(user,userVo);
            return userVo;
        }
        return null;
    }
}
