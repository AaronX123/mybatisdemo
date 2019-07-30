package com.bosssoft.hr.train.controller;


import com.bosssoft.hr.train.aop.LogRequest;
import com.bosssoft.hr.train.aop.ParamValidate;
import com.bosssoft.hr.train.error.BusinessException;
import com.bosssoft.hr.train.error.EnumBusinessError;
import com.bosssoft.hr.train.pojo.entity.Dictionary;
import com.bosssoft.hr.train.pojo.vo.DictionaryEditVo;
import com.bosssoft.hr.train.pojo.vo.DictionaryVo;
import com.bosssoft.hr.train.request.CommonRequest;
import com.bosssoft.hr.train.response.CommonResponse;
import com.bosssoft.hr.train.service.CommonService;
import com.bosssoft.hr.train.service.DictionaryService;
import com.bosssoft.hr.train.util.GetBean;
import com.bosssoft.hr.train.util.RedisUtil;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-24
 */

@Controller("dictionary")
@RequestMapping("/dictionary")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class DictionaryController extends ExceptionController{

    private Gson gson=new Gson();
    /**
     * 添加DictionaryService
     */
    @Autowired
    DictionaryService dictionaryService;
    @Autowired
    CommonService commonService;

    /**
     * 展示字典信息通过id
     * @param request CommmonRequest
     * @return 加了ResponseBody就直接以json形式返回给浏览器了
     */
    @ParamValidate
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse showDictionary(@RequestBody CommonRequest request) throws BusinessException {
        Object data=request.getData();
        Long id= Long.valueOf(data.toString());
        Dictionary dictionary= dictionaryService.getDictionaryById(id);
        if (dictionary==null){
            return CommonResponse.create("无此信息","fail");
        }else {
            DictionaryVo dictionaryVo=convertDictionaryVoFromDictionary(dictionary);
            return CommonResponse.create(dictionaryVo);
        }

    }

    /**
     * 保存字典信息
     * @param request 通用Request
     * @return 如果保存成功返回通用Response
     * @throws BusinessException 保存失败或者参数错误则抛出异常
     */
    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    @ResponseBody
    public CommonResponse saveDictionary(@RequestBody CommonRequest request) throws BusinessException {
        String requestMsg=  request.getData().toString();
        if (requestMsg==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        //获取Vo对象从request.data中
        DictionaryVo dictionaryVo=gson.fromJson(requestMsg,DictionaryVo.class);
        //把真正的业务实体构造出来
        Dictionary dictionary=convertDictionaryFromDictionaryVo(dictionaryVo);
        if (dictionaryVo==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }else {
            if (dictionaryService.insertDictionary(dictionary)){
                return CommonResponse.create("插入成功");
            }else {
                return CommonResponse.create("插入失败","fail");
            }
        }
    }

    /**
     * 列出所有字典信息
     *
     * @return 一个CommonResponse里包含了字典的集合
     * @throws BusinessException 如果字典为空则抛出数据不存在异常
     */
    @RequestMapping(value = "/queryAll",method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse listAllDictionary() throws BusinessException {
        return CommonResponse.create(dictionaryService.listDictionary());
    }

    /**
     * 修改字典
     * @param request CommonRequest包含要更新的字典信息
     * @return 更新成功则返回<code>CommonResponse.create("更新成功");</code>
     * @throws BusinessException 更新失败或者参数错误则抛出异常
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse editDictionary(@RequestBody CommonRequest request) throws BusinessException {
        String requestMsg= (String) request.getData().toString();
        if (requestMsg==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        //此时id为String类型需要进行转换
        DictionaryEditVo dictionaryEditVo=gson.fromJson(requestMsg,DictionaryEditVo.class);
        Dictionary dictionary=convertDictionaryFromDictionaryEditVo(dictionaryEditVo);
        if (dictionaryService.updateDictionary(dictionary)){
            return CommonResponse.create("更新成功");
        }else {
            return CommonResponse.create("更新失败","fail");
        }
    }

    /**
     * 删除字典信息
     * @param request CommonRequest包含字典id
     * @return 删除成功返回<code>CommonResponse.create("删除成功");</code>
     * @throws BusinessException 如果此id对应的字典不存在或参数错误则抛出异常
     */
    @RequestMapping(value = "/del")
    @ResponseBody
    public CommonResponse deletDictionary(@RequestBody CommonRequest request) throws BusinessException {
        String requestString=request.getData().toString();
        if (requestString==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Long id=gson.fromJson(requestString,Long.class);
        if (dictionaryService.deleteById(id)){
            return CommonResponse.create("删除成功");
        }
        return CommonResponse.create("删除失败","fail");
    }

    private DictionaryVo convertDictionaryVoFromDictionary(Dictionary dictionary) {
        if (dictionary==null){
            return null;
        }
        DictionaryVo dictionaryVo=new DictionaryVo();
        BeanUtils.copyProperties(dictionary,dictionaryVo);
        return dictionaryVo;
    }


    /**
     * 将前端传来的Vo转换为Dictionary
     * @param dictionaryVo 前端传来的数据
     * @return 补充完整的实体类
     * @throws BusinessException 如果生成id失败则抛出异常
     */
    private Dictionary convertDictionaryFromDictionaryVo(DictionaryVo dictionaryVo) throws BusinessException {
        Dictionary dictionary=new Dictionary();
        //获得雪花算法生成的唯一id
        Long id= commonService.generateId();
        //获得Status
        String status="1";
        //获得Creator
        String creator=commonService.getUserName();
        //获得createTime
        Date createTime=commonService.getDate();
        //default Version 1.0
        String version="1.0";
        dictionary.setVersion(version);
        dictionary.setStatus(status);
        dictionary.setId(id);
        dictionary.setCreateTime(createTime);
        dictionary.setCreator(creator);
        BeanUtils.copyProperties(dictionaryVo,dictionary);
        return dictionary;
    }

    /**
     * 转换成更新后的实体类
     * @param dictionaryEditVo 前端传来的部分属性
     * @return 更新后的实体类
     * @throws BusinessException 如果没有此id对应字典属性
     */
    private Dictionary convertDictionaryFromDictionaryEditVo(DictionaryEditVo dictionaryEditVo) throws BusinessException {
        Long id=dictionaryEditVo.getId();
        Dictionary dictionary=dictionaryService.getDictionaryById(id);
        BeanUtils.copyProperties(dictionaryEditVo,dictionary);
        dictionary.setUpdateTime(commonService.getDate());
        dictionary.setUpdater(commonService.getUserName());
        return dictionary;
    }
}
