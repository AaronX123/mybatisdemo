package com.bosssoft.hr.train.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典的领域模型
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-24
 */
public class Dictionary implements Serializable {


    private static final long serialVersionUID = 1908823302809164843L;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String dictionaryName;
    private String dictionaryType;
    private String dictionaryValue;
    private String mark;
    private String comment;
    private String status;
    private String orgid;
    private String creator;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date createTime;
    private String updater;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date updateTime;
    private String version;

    public Dictionary() {
    }

    public Dictionary(Long id,String dictionaryName, String dictionaryType, String dictionaryValue,String mark, String comment, String status, String orgid, String creator, Date createTime, String updater, Date updateTime, String version) {
        this.id = id;
        this.dictionaryName=dictionaryName;
        this.dictionaryType = dictionaryType;
        this.dictionaryValue = dictionaryValue;
        this.mark=mark;
        this.comment = comment;
        this.status = status;
        this.orgid = orgid;
        this.creator = creator;
        this.createTime = createTime;
        this.updater = updater;
        this.updateTime = updateTime;
        this.version = version;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", dictionaryName='" + dictionaryName + '\'' +
                ", dictionaryType='" + dictionaryType + '\'' +
                ", dictionaryValue='" + dictionaryValue + '\'' +
                ", mark='" + mark + '\'' +
                ", comment='" + comment + '\'' +
                ", status='" + status + '\'' +
                ", orgid='" + orgid + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updater='" + updater + '\'' +
                ", updateTime=" + updateTime +
                ", version='" + version + '\'' +
                '}';
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }
}
