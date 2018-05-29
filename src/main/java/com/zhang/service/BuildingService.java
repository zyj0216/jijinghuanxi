package com.zhang.service;

import com.zhang.DAO.BuildingImpl;
import com.zhang.entity.Building;

import java.util.List;

/**
 * Created by Administrator on 2018/5/23.
 */
public class BuildingService {
    BuildingImpl buildingImpl = new BuildingImpl();
    /**
     * 查询所有楼宇
     */
    public List<Building> selectAll(){
        String sql = "select * from building";
        Object[] objects = null;
        return buildingImpl.executeQuery(sql,objects);
    }

    /**
     * 添加楼宇
     */
    public int addBuilding(Building building){
        String sql = "insert into building values(null,?,?,?)";
        Object[] objects = new Object[]{
                building.getBuilding_name(),
                building.getBuilding_type(),
                building.getBuilding_introduction()
        };
        return buildingImpl.executeUpdate(sql,objects);
    }

    /**
     * 根据输入的名称查询
     */
    public Building selectByOptionValues(String option_values){
        String sql = "select * from building where building_name=?";
        Object[] objects = new Object[]{option_values};
        List<Building> list = buildingImpl.executeQuery(sql,objects);
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    /**
     * 删除楼宇信息
     */
    public int deleteByBuildingID(int building_id){
        String sql = "delete from building where building_id=?";
        Object[] objects = new Object[]{building_id};
        return buildingImpl.executeUpdate(sql,objects);
    }

    /**
     * 根据ID查询楼宇信息
     */
    public Building selectByID(int building_id){
        String sql = "select * from building where building_id=?";
        Object[] objects = new Object[]{building_id};
        List<Building> list = buildingImpl.executeQuery(sql,objects);
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    /**
     * 修改楼宇信息
     */
    public int update(Building building){
        String sql = "update building set building_name=?,building_type=?,building_introduction=? where building_id=?";
        Object[] objects = new Object[]{
               building.getBuilding_name(),
                building.getBuilding_type(),
                building.getBuilding_introduction(),
                building.getBuilding_id()
        };
        return buildingImpl.executeUpdate(sql,objects);
    }



}
