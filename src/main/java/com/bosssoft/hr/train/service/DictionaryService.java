package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.error.BusinessException;
import com.bosssoft.hr.train.pojo.entity.Dictionary;

import java.util.ArrayList;

/**
 * 字典Service接口
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-24
 */
public interface DictionaryService {
    /**
     * 通过id获取字典对象
     * @param id 字典id
     * @return 字典对象
     */
    Dictionary getDictionaryById(Long id) throws BusinessException;

    /**
     * 插入字典对象
     * @param dictionary 字典对象
     * @return 插入成功返回true否则返回false
     */
    boolean insertDictionary(Dictionary dictionary) throws BusinessException;

    /**
     * 更新字典信息
     * @param dictionary 字典对象
     * @return 更新成功返回true否则返回false
     */
    boolean updateDictionary(Dictionary dictionary) throws BusinessException;

    /**
     * 删除字典信息
     * @param dictionary 字典对象
     * @return 删除成功返回true否则返回false
     */
    boolean deleteDictionary(Dictionary dictionary) throws BusinessException;

    /**
     * 获取所有字典信息
     * @return 字典信息List
     * @throws BusinessException 如果字典表为空就抛出异常
     */
    ArrayList<Dictionary> listDictionary() throws BusinessException;

    /**
     * 通过ID来删除
     * @param id id
     * @return 删除成功返回true否则返回false
     */
    boolean deleteById(Long id);

}
