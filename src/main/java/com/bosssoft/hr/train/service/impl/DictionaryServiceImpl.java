package com.bosssoft.hr.train.service.impl;

import com.bosssoft.hr.train.aop.LogService;
import com.bosssoft.hr.train.error.BusinessException;
import com.bosssoft.hr.train.error.EnumBusinessError;
import com.bosssoft.hr.train.mapper.DictionaryMapper;
import com.bosssoft.hr.train.pojo.dto.DictionaryDto;
import com.bosssoft.hr.train.pojo.entity.Dictionary;
import com.bosssoft.hr.train.service.DictionaryService;
import com.bosssoft.hr.train.util.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-24
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {


    @Autowired
    DictionaryMapper mapper;
    @Autowired
    RedisUtil redisUtil;
    /**
     * 通过ID查询字典信息
     * @param id 字典id
     * @return 字典信息
     */
    @LogService
    @Override
    public Dictionary getDictionaryById(Long id) throws BusinessException {
        if (id==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        DictionaryDto dictionaryDto=mapper.selectByPrimaryKey(id);
        if (dictionaryDto==null){
            throw new BusinessException(EnumBusinessError.DATA_NOTEXSIST);
        }
        return convertDictionaryFromDictionaryDto(dictionaryDto);
    }

    /**
     * 通过领域模型插入
     * @param dictionary 字典的领域模型
     * @return 插入成功返回true否则返回false
     */
    @Override
    @Transactional(rollbackForClassName = {"Exception.class"})
    public boolean insertDictionary(Dictionary dictionary) throws BusinessException {
        if (dictionary==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        redisUtil.set(dictionary.getId().toString(),dictionary);
        //这里设置它为非null是因为BeanUtils.copyProperties方法中对参数进行notNull断言
        DictionaryDto dictionaryDto=new DictionaryDto();
        dictionaryDto=convertDictionaryDtoFromDictionary(dictionary);
        if (dictionaryDto==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        //insertSelective比insert多了一层判断字段非null，增加了安全性
        return mapper.insertSelective(dictionaryDto)>0;
    }
    @Override
    @Transactional(rollbackForClassName = {"Exception.class"})
    public boolean updateDictionary(Dictionary dictionary) throws BusinessException {
        //先更新redis中的,如果这个key有则更新value否则插入进去
        redisUtil.set(dictionary.getId().toString(),dictionary);
        DictionaryDto dictionaryDto=new DictionaryDto();
        dictionaryDto=convertDictionaryDtoFromDictionary(dictionary);
        if (dictionaryDto==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        //updateByPrimaryKeySelective比updateByPrimaryKey多了一层判断字段非null，增加了安全性
        return mapper.updateByPrimaryKeySelective(dictionaryDto)>0;
    }

    /**
     * 删除字典信息
     *
     * @param dictionary 字典对象
     * @return 删除成功返回true否则返回false
     */

    @Override
    @Transactional(rollbackForClassName = {"Exception.class"})
    public boolean deleteDictionary(Dictionary dictionary) throws BusinessException {
        DictionaryDto dictionaryDto=new DictionaryDto();
        dictionaryDto=convertDictionaryDtoFromDictionary(dictionary);
        if (dictionaryDto==null){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        return mapper.delete(dictionaryDto)>0;
    }

    /**
     * 获取所有字典信息
     * @return 字典信息List
     * @throws BusinessException 如果字典表为空就抛出异常
     */
    @Override
    public ArrayList<Dictionary> listDictionary() throws BusinessException {
        //从Redis中获取value
        Set<String> keySet=redisUtil.getKeys();
        ArrayList valueList=new ArrayList();
        for (String key : keySet){
            valueList.add(redisUtil.get(key));
        }
        if (redisUtil.getTableSize()<1000){
            Random random=new Random();
            //从数据库中查询所有
            List<DictionaryDto> list=mapper.selectAll();
            if (list==null||list.size()==0){
                throw new BusinessException(EnumBusinessError.DATA_NOTEXSIST.setErrorMessage("字典表为空"));
            }
            //取出Dto并转为Entity
            ArrayList<Dictionary> entityList=new ArrayList<Dictionary>();
            for (DictionaryDto dto:list){
                entityList.add(convertDictionaryFromDictionaryDto(dto));
            }
            for (Dictionary dictionary:entityList){
                redisUtil.set(dictionary.getId().toString(),dictionary,43200+random.nextInt(1000));
            }
        }

        return valueList;
    }

    /**
     * 通过ID来删除
     *
     * @param id id
     * @return 删除成功返回true否则返回false
     */
    @Override
    @Transactional(rollbackForClassName = {"Exception.class"})
    public boolean deleteById(Long id) {
        //先看redis中是否缓存了此id的值如果有就一起删除
        redisUtil.del(id.toString());
        return mapper.deleteByPrimaryKey(id)>0;
    }


    /**
     * 从数据库到Service层通过Dto
     * 将ORM装换成领域模型（DO）
     * @param dictionaryDto 数据库映射对象
     * @return 字典领域模型
     */
    private Dictionary convertDictionaryFromDictionaryDto(DictionaryDto dictionaryDto){
        Dictionary dictionary = new Dictionary();
        BeanUtils.copyProperties(dictionaryDto,dictionary);
        return dictionary;
    }

    /**
     * 从Controller到Service通过DO
     * 将领域模型转换成DTO
     * @param dictionary 字典领域模型
     * @return 字典数据库映射模型
     */
    private DictionaryDto convertDictionaryDtoFromDictionary(Dictionary dictionary){
        DictionaryDto dictionaryDto=new DictionaryDto();
        BeanUtils.copyProperties(dictionary,dictionaryDto);
        return dictionaryDto;
    }
}
