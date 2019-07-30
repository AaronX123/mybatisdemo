package com.bosssoft.hr.train.util;

import com.bosssoft.hr.train.pojo.vo.DictionaryVo;
import com.bosssoft.hr.train.util.reflect.MethodFactory;
import com.bosssoft.hr.train.util.reflect.MismatchException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-27
 */
public class GetBean<T> {
    @Deprecated
    public T getBean(LinkedHashMap map,Class targetClass,T target) throws NoSuchMethodException, MismatchException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        if (map!=null&&targetClass!=null){
            if (target.getClass().equals(targetClass)){
                //先获取Key名字，然后调用target类的set方法
                Iterator keyIterator=map.keySet().iterator();
                Field[] fields=targetClass.getDeclaredFields();
                while (keyIterator.hasNext()){
                    String keyname= (String) keyIterator.next();
                    for (int i=0;i<fields.length;i++){
                        if (fields[i].getName().equals(keyname)){
                            Method method=MethodFactory.getMethod("set",fields[i],targetClass);
                            if (method!=null){
                                method.invoke(target);
                                break;
                            }
                        }
                    }
                }
            }

        }
        return target;
    }

    /**
     * 将request中的data转换为DictionaryVo
     * @param map data是以LinkedHashMap存放
     * @return DictionaryVo
     */
    public DictionaryVo getDictionaryVo(LinkedHashMap map){
        if (map!=null){
            DictionaryVo dictionaryVo=new DictionaryVo();
            Iterator iterator=map.entrySet().iterator();
            Map.Entry entry= (Map.Entry) iterator.next();
            String dictionaryType= (String) entry.getValue();
            entry= (Map.Entry) iterator.next();
            String dictionaryValue= (String) entry.getValue();
            entry= (Map.Entry) iterator.next();
            String comment= (String) entry.getValue();
            entry= (Map.Entry) iterator.next();
            String orgid= (String) entry.getValue();
            if (dictionaryType!=null&&dictionaryValue!=null&&comment!=null&&orgid!=null){
                dictionaryVo.setDictionaryType(dictionaryType);
                dictionaryVo.setDictionaryValue(dictionaryValue);
                dictionaryVo.setComment(comment);
                dictionaryVo.setOrgid(orgid);
            }
            return dictionaryVo;
        }
        return null;
    }

}
