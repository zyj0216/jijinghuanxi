package com.zhang.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/17.
 */
public class Student implements Serializable {

    private int student_id;
    private int domitory_number;
    private int teacher_id;
    private int building_id;
    private String student_username;
    private String student_password;
    private String student_name;
    private String student_tel;
    private String student_class;
    private String student_state;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getDomitory_number() {
        return domitory_number;
    }

    public void setDomitory_number(int domitory_number) {
        this.domitory_number = domitory_number;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public String getStudent_username() {
        return student_username;
    }

    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_tel() {
        return student_tel;
    }

    public void setStudent_tel(String student_tel) {
        this.student_tel = student_tel;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getStudent_state() {
        return student_state;
    }

    public void setStudent_state(String student_state) {
        this.student_state = student_state;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", domitory_number=" + domitory_number +
                ", teacher_id=" + teacher_id +
                ", building_id=" + building_id +
                ", student_username='" + student_username + '\'' +
                ", student_password='" + student_password + '\'' +
                ", student_name='" + student_name + '\'' +
                ", student_tel='" + student_tel + '\'' +
                ", student_class='" + student_class + '\'' +
                ", student_state='" + student_state + '\'' +
                '}';
    }
}
