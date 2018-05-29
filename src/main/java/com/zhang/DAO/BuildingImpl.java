package com.zhang.DAO;

import com.zhang.entity.Building;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/17.
 */
public class BuildingImpl extends BaseDAO<Building> {
    @Override
    public List<Building> rsToList(ResultSet rs) throws SQLException {
        List<Building> list = new ArrayList<Building>();
        while (rs.next()){
            Building building = new Building();
            building.setBuilding_id(rs.getInt("building_id"));
            building.setBuilding_name(rs.getString("building_name"));
            building.setBuilding_type(rs.getString("building_type"));
            building.setBuilding_introduction(rs.getString("building_introduction"));
            list.add(building);
        }
        return list;
    }
}
