package com.bosssoft.hr.train.util.reflect;

/**
 * 传入的参数既不是set也不是get时抛出此异常
 * @author xiaoyouming
 * @version 1.0
 * @updateTime 2019-07-20
 * @lastEditor
 * @since 2019-07-20
 */
public class MismatchException extends Exception{
    public MismatchException(){
        super("方法不是set或get");
    }
}
