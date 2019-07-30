package com.bosssoft.hr.train.util.reflect;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * @apiNote 通过此类可以获得属性的返回类型及Method
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-20
 *
 */
public class MethodFactory {
    private  static final String TYPE_GET="get";
    private  static final String TYPE_SET="set";


    /**
     * 返回指定字段的Class,如果只是<code>field.getGenericType().getClass()</code>返回的是Class类型
     * @param field 字段
     * @return 返回指定字段的Class
     * @throws NoSuchFieldException 如果传来空的field抛出此异常
     */
    public static Class getFieldReturnType(Field field) throws NoSuchFieldException {
        if (field==null){
            throw new NoSuchFieldException();
        }
        //获取Type
        Type fieldGenericType=field.getGenericType();
        if (StringUtils.equals(fieldGenericType.toString(), TYPE.STRING.getClassName())){
            return String.class;
        }if (StringUtils.equals(fieldGenericType.toString(), TYPE.INTEGER.getClassName())){
            return Integer.class;
        }if (StringUtils.equals(fieldGenericType.toString(), TYPE.FLOAT.getClassName())){
            return Float.class;
        }if (StringUtils.equals(fieldGenericType.toString(), TYPE.CHARACTER.getClassName())){
            return Character.class;
        }if (StringUtils.equals(fieldGenericType.toString(), TYPE.DOUBLE.getClassName())){
            return Double.class;
        }if (StringUtils.equals(fieldGenericType.toString(), TYPE.INTEGER.getClassName())){
            return Integer.class;
        }if (StringUtils.equals(fieldGenericType.toString(), TYPE.UTILDATE.getClassName())){
            return Date.class;
        }else {
            return Object.class;
        }
    }

    /**
     * 通过Class来获得该类的get/set方法，如果类没有属性则抛出异常。
     * @param methodType 需要获得什么类型的方法比如setter
     * @param clazz 类对象
     * @return Method数组，包含所有属性的指定类型方法
     * @throws NoSuchMethodException 当此方法为private或者类设计时不是getXXX()/setXXX(Type t)时抛出此异常
     * @throws MismatchException 当methodType不是set或get时抛出异常
     */
    @SuppressWarnings("unchecked")
    public static Method[] getMethods(String methodType,Class clazz) throws NoSuchMethodException, MismatchException, NoSuchFieldException {
        if(StringUtils.isNotEmpty(methodType)&&clazz!=null){
            Field[] fields=clazz.getDeclaredFields();

            int length=fields.length;
            //获得属性名字
            String[] fieldName=new String[length];
            for (int i=0;i< length;i++){
                fieldName[i]=fields[i].getName();
            }
            //拼装成getterxxx/setterxxx
            Method[] methods=new Method[length];
            //传入的方法类型既不是get也不是set那么抛出异常
            if (!StringUtils.equals(methodType,TYPE_GET)&&!StringUtils.equals(methodType,TYPE_SET)){
                throw new MismatchException();
            }else {
                for (int i=0;i<length;i++){
                    //获取该类的方法
                    if (StringUtils.equals(methodType,TYPE_SET)){
                        Method method=clazz.getMethod(methodType+ UpperCaseTheFirstStringLetter.upperCaseFirstLetter(fieldName[i]),getFieldReturnType(fields[i]));
                        if (method!=null){
                            //避免安全检查加快速度
                            method.setAccessible(true);
                            methods[i]=method;
                        }
                    }else {
                        Method method=clazz.getMethod(methodType+UpperCaseTheFirstStringLetter.upperCaseFirstLetter(fieldName[i]));
                        if (method!=null){
                            method.setAccessible(true);
                            methods[i]=method;
                        }
                    }

                }
            }
            return methods;
        }else {
            return null;
        }

    }

    /**
     * @apiNote 获取一个Method
     * @param methodType 需要获得什么类型的方法比如setter
     * @param field 类的属性
     * @param clazz 类对象
     * @return 一个getter/setter Method
     * @throws MismatchException 当methodType不是set或get时抛出异常
     * @throws NoSuchMethodException 当此方法为private或者类设计时不是getXXX()/setXXX(Type t)时抛出此异常
     */
    @SuppressWarnings("unchecked")
    public static Method getMethod(String methodType,Field field,Class clazz) throws MismatchException, NoSuchMethodException, NoSuchFieldException {
        //参数校验
        if(StringUtils.isNotEmpty(methodType)&&field!=null){
            //获取属性名
            String fieldName=field.getName();
            //如果既不是set也不是get说明不是构造setter/getter抛出异常
            if (!StringUtils.equals(methodType,TYPE_GET)&&!StringUtils.equals(methodType,TYPE_SET)){
                throw new MismatchException();
            }else {
                //如果是set，则需要额外添加参数
                if (StringUtils.equals(methodType,TYPE_SET)){
                    return clazz.getMethod(methodType+UpperCaseTheFirstStringLetter.upperCaseFirstLetter(fieldName),getFieldReturnType(field));
                }else {
                    return clazz.getMethod(methodType+UpperCaseTheFirstStringLetter.upperCaseFirstLetter(fieldName));
                }
            }
        }else {
            return null;
        }
    }
}
