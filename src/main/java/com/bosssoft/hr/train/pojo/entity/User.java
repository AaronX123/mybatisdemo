package com.bosssoft.hr.train.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-25
 */
public class User implements Serializable {
    private static final long serialVersionUID = 7800381378733187248L;
    private Integer id;
    /**
     *
     */
    private String password;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private Boolean gender;

    private Date birthday;

    private String position;

    private String tel;

    private String email;

    private String phone;

    private String comment;

    private String status;

    private String creator;

    private Date createdTime;

    private String updater;

    private Date updatedTime;

    private String version;

    public User() {
    }

    public User(Integer id, String password, String name, Boolean gender, Date birthday, String position, String tel, String email, String phone, String comment, String status, String creator, Date createTime, String updater, Date updateTime, String version) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.position = position;
        this.tel = tel;
        this.email = email;
        this.phone = phone;
        this.comment = comment;
        this.status = status;
        this.creator = creator;
        this.createdTime = createTime;
        this.updater = updater;
        this.updatedTime = updateTime;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createdTime;
    }

    public void setCreateTime(Date createTime) {
        this.createdTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updatedTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updatedTime = updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", position=" + position +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", comment='" + comment + '\'' +
                ", status='" + status + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createdTime +
                ", updater='" + updater + '\'' +
                ", updateTime=" + updatedTime +
                ", version='" + version + '\'' +
                '}';
    }
}
