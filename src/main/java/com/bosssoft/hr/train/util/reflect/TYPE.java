package com.bosssoft.hr.train.util.reflect;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since  2019-07-18
 */
public enum TYPE {
    /**
     * Integer的类名
     */
    INTEGER("class java.lang.Integer"),
    /**
     * String的类名
     */
    STRING("class java.lang.String"),
    /**
     * util.Date的类名
     */
    UTILDATE("class java.util.Date"),
    /**
     * Character的类名
     */
    CHARACTER("class java.lang.Character"),
    /**
     * Long的类名
     */
    LONG("class java.lang.Long"),
    /**
     * Double的类名
     */
    DOUBLE("class java.lang.Double"),
    /**
     * Float的类名
     */
    FLOAT("class java.lang.Float"),
    /**
     * sql.Date的类名
     */
    SQLDATE("class java.sql.Date")
    ;

    TYPE(String className) {
        this.className = className;
    }

    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
