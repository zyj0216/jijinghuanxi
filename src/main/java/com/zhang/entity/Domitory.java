package com.zhang.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/17.
 */
public class Domitory implements Serializable {
    private int building_id;
    private int domitory_number;
    private int domitory_type;
    private int domitory_tel;
    private int domitory_person;

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

    public int getDomitory_type() {
        return domitory_type;
    }

    public void setDomitory_type(int domitory_type) {
        this.domitory_type = domitory_type;
    }

    public int getDomitory_tel() {
        return domitory_tel;
    }

    public void setDomitory_tel(int domitory_tel) {
        this.domitory_tel = domitory_tel;
    }

    public int getDomitory_person() {
        return domitory_person;
    }

    public void setDomitory_person(int domitory_person) {
        this.domitory_person = domitory_person;
    }

    @Override
    public String toString() {
        return "DomitoryService{" +
                "building_id=" + building_id +
                ", domitory_number=" + domitory_number +
                ", domitory_type=" + domitory_type +
                ", domitory_tel=" + domitory_tel +
                ", domitory_person=" + domitory_person +
                '}';
    }
}
