package com.bosssoft.hr.train.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-29
 */
public class DictionaryEditVo implements Serializable {
    private static final long serialVersionUID = 9046732466555825848L;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String dictionaryName;
    private String dictionaryType;
    private String dictionaryValue;
    private String comment;
    private String status;

    public DictionaryEditVo() {
    }

    public DictionaryEditVo(Long id, String dictionaryName, String dictionaryType, String dictionaryValue, String comment, String status) {
        this.id = id;
        this.dictionaryName = dictionaryName;
        this.dictionaryType = dictionaryType;
        this.dictionaryValue = dictionaryValue;
        this.comment = comment;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
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

    @Override
    public String toString() {
        return "DictionaryEditVo{" +
                "id=" + id +
                ", dictionaryName='" + dictionaryName + '\'' +
                ", dictionaryType='" + dictionaryType + '\'' +
                ", dictionaryValue='" + dictionaryValue + '\'' +
                ", comment='" + comment + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
