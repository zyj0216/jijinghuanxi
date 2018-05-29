package com.zhang.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/17.
 */
public class TB implements Serializable {
    private int TB_id;
    private int student_id;
    private int teacher_id;
    private String TB_date;
    private int building_id;
    private int domitory_number;

    public int getTB_id() {
        return TB_id;
    }

    public void setTB_id(int TB_id) {
        this.TB_id = TB_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTB_date() {
        return TB_date;
    }

    public void setTB_date(String TB_date) {
        this.TB_date = TB_date;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public int getDomitory_number() {
        return domitory_number;
    }

    public void setDomitory_number(int domitory_number) {
        this.domitory_number = domitory_number;
    }

    @Override
    public String toString() {
        return "TB{" +
                "TB_id=" + TB_id +
                ", student_id=" + student_id +
                ", teacher_id=" + teacher_id +
                ", TB_date='" + TB_date + '\'' +
                ", building_id=" + building_id +
                ", domitory_number=" + domitory_number +
                '}';
    }
}
