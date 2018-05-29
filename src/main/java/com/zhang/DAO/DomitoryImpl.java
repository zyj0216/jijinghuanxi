package com.zhang.DAO;

import com.zhang.entity.Domitory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/17.
 */
public class DomitoryImpl extends BaseDAO<Domitory> {
    @Override
    public List<Domitory> rsToList(ResultSet rs) throws SQLException {
        List<Domitory> list = new ArrayList<Domitory>();
        while (rs.next()){
            Domitory domitory = new Domitory();
            domitory.setBuilding_id(rs.getInt("building_id"));
            domitory.setDomitory_number(rs.getInt("domitory_number"));
            domitory.setDomitory_type(rs.getInt("domitory_type"));
            domitory.setDomitory_tel(rs.getInt("domitory_tel"));
            domitory.setDomitory_person(rs.getInt("domitory_person"));
            list.add(domitory);
        }
        return list;
    }
}
