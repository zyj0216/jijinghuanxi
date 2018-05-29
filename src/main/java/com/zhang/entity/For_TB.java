package com.zhang.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/25.
 */
public class For_TB implements Serializable {
    private String name;
    private String stuclass;
    private int domitory_no;
    private String data_tb;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuclass() {
        return stuclass;
    }

    public void setStuclass(String stuclass) {
        this.stuclass = stuclass;
    }

    public int getDomitory_no() {
        return domitory_no;
    }

    public void setDomitory_no(int domitory_no) {
        this.domitory_no = domitory_no;
    }

    public String getData_tb() {
        return data_tb;
    }

    public void setData_tb(String data_tb) {
        this.data_tb = data_tb;
    }

    @Override
    public String toString() {
        return "For_TB{" +
                "name='" + name + '\'' +
                ", stuclass='" + stuclass + '\'' +
                ", domitory_no=" + domitory_no +
                ", data_tb='" + data_tb + '\'' +
                '}';
    }
}
