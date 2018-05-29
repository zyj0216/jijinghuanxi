package com.zhang.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/17.
 */
public class Admin implements Serializable{

    private int admin_id;
    private String admin_username;
    private String admin_password;
    private String admin_name;
    private String admin_sex;
    private String admin_tel;

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_sex() {
        return admin_sex;
    }

    public void setAdmin_sex(String admin_sex) {
        this.admin_sex = admin_sex;
    }

    public String getAdmin_tel() {
        return admin_tel;
    }

    public void setAdmin_tel(String admin_tel) {
        this.admin_tel = admin_tel;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_username='" + admin_username + '\'' +
                ", admin_password='" + admin_password + '\'' +
                ", admin_name='" + admin_name + '\'' +
                ", admin_sex='" + admin_sex + '\'' +
                ", admin_tel='" + admin_tel + '\'' +
                '}';
    }
}
