package com.zhang.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/17.
 */
public class Building implements Serializable {
    private int building_id;
    private String building_name;
    private String building_type;
    private String building_introduction;

    public int getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }

    public String getBuilding_type() {
        return building_type;
    }

    public void setBuilding_type(String building_type) {
        this.building_type = building_type;
    }

    public String getBuilding_introduction() {
        return building_introduction;
    }

    public void setBuilding_introduction(String building_introduction) {
        this.building_introduction = building_introduction;
    }

    @Override
    public String toString() {
        return "Building{" +
                "building_id=" + building_id +
                ", building_name='" + building_name + '\'' +
                ", building_type='" + building_type + '\'' +
                ", building_introduction='" + building_introduction + '\'' +
                '}';
    }
}
