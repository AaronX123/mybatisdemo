package com.bosssoft.hr.train.pojo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-25
 */
public class DictionaryVo implements Serializable {

    private static final long serialVersionUID = 7239501392862444664L;
    private String mark;
    private String dictionaryName;
    private String dictionaryType;
    private String dictionaryValue;
    private String comment;
    private String orgid;
    private Date updateTime;

    public DictionaryVo() {
    }

    public DictionaryVo(String mark,String dictionaryType, String dictionaryValue, String comment, String orgid,String dictionaryName,Date updateTime) {
        this.mark=mark;
        this.dictionaryType = dictionaryType;
        this.dictionaryValue = dictionaryValue;
        this.comment = comment;
        this.orgid = orgid;
        this.dictionaryName=dictionaryName;
        this.updateTime=updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDictionaryType() {
        return dictionaryType;
    }

    public void setDictionaryType(String dictionaryType) {
        this.dictionaryType = dictionaryType;
    }

    public String getDictionaryValue() {
        return dictionaryValue;
    }

    public void setDictionaryValue(String dictionaryValue) {
        this.dictionaryValue = dictionaryValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    @Override
    public String toString() {
        return "DictionaryVo{" +
                "mark='" + mark + '\'' +
                ", dictionaryName='" + dictionaryName + '\'' +
                ", dictionaryType='" + dictionaryType + '\'' +
                ", dictionaryValue='" + dictionaryValue + '\'' +
                ", comment='" + comment + '\'' +
                ", orgid='" + orgid + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
