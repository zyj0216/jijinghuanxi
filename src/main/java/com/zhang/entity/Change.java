package com.zhang.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/17.
 */
public class Change implements Serializable {
    private int change_id;
    private int student_id;
    private String change_date;
    private int admin_id;
    private int beforebuilding_id;
    private int beforedomotory_number;
    private int afterbuilding_id;
    private int afterdomitory_id;
    private int afterdomitory_number;

    public int getChange_id() {
        return change_id;
    }

    public void setChange_id(int change_id) {
        this.change_id = change_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getChange_date() {
        return change_date;
    }

    public void setChange_date(String change_date) {
        this.change_date = change_date;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getBeforebuilding_id() {
        return beforebuilding_id;
    }

    public void setBeforebuilding_id(int beforebuilding_id) {
        this.beforebuilding_id = beforebuilding_id;
    }

    public int getBeforedomotory_number() {
        return beforedomotory_number;
    }

    public void setBeforedomotory_number(int beforedomotory_number) {
        this.beforedomotory_number = beforedomotory_number;
    }

    public int getAfterbuilding_id() {
        return afterbuilding_id;
    }

    public void setAfterbuilding_id(int afterbuilding_id) {
        this.afterbuilding_id = afterbuilding_id;
    }

    public int getAfterdomitory_id() {
        return afterdomitory_id;
    }

    public void setAfterdomitory_id(int afterdomitory_id) {
        this.afterdomitory_id = afterdomitory_id;
    }

    public int getAfterdomitory_number() {
        return afterdomitory_number;
    }

    public void setAfterdomitory_number(int afterdomitory_number) {
        this.afterdomitory_number = afterdomitory_number;
    }

    @Override
    public String toString() {
        return "Change{" +
                "change_id=" + change_id +
                ", student_id=" + student_id +
                ", change_date='" + change_date + '\'' +
                ", admin_id=" + admin_id +
                ", beforebuilding_id=" + beforebuilding_id +
                ", beforedomotory_number=" + beforedomotory_number +
                ", afterbuilding_id=" + afterbuilding_id +
                ", afterdomitory_id=" + afterdomitory_id +
                ", afterdomitory_number=" + afterdomitory_number +
                '}';
    }
}
