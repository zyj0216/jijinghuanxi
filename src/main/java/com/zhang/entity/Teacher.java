package com.zhang.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/17.
 */
public class Teacher implements Serializable {

    private int teacher_id;
    private String teacher_uname;
    private String teacher_password;
    private String teacher_name;
    private String teacher_sex;
    private String teacher_tel;
    private int building_id;

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_uname() {
        return teacher_uname;
    }

    public void setTeacher_uname(String teacher_uname) {
        this.teacher_uname = teacher_uname;
    }

    public String getTeacher_password() {
        return teacher_password;
    }

    public void setTeacher_password(String teacher_password) {
        this.teacher_password = teacher_password;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_sex() {
        return teacher_sex;
    }

    public void setTeacher_sex(String teacher_sex) {
        this.teacher_sex = teacher_sex;
    }

    public String getTeacher_tel() {
        return teacher_tel;
    }

    public void setTeacher_tel(String teacher_tel) {
        this.teacher_tel = teacher_tel;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", teacher_uname='" + teacher_uname + '\'' +
                ", teacher_password='" + teacher_password + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_sex='" + teacher_sex + '\'' +
                ", teacher_tel='" + teacher_tel + '\'' +
                ", building_id=" + building_id +
                '}';
    }
}
