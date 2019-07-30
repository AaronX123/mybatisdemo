package com.bosssoft.hr.train.pojo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-25
 */
public class UserVo implements Serializable {
    private static final long serialVersionUID = -8697199132061245680L;
    private Integer id;

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


    public UserVo() {
    }

    public UserVo(Integer id, String name, Boolean gender, Date birthday, String position, String tel, String email, String phone, String comment, String status) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.position = position;
        this.tel = tel;
        this.email = email;
        this.phone = phone;
        this.comment = comment;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", position='" + position + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", comment='" + comment + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
