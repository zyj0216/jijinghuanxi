package com.zhang.DAO;

import com.zhang.entity.TB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/17.
 */
public class TBImpl extends BaseDAO<TB> {
    @Override
    public List<TB> rsToList(ResultSet rs) throws SQLException {
        List<TB> list = new ArrayList<TB>();
        while (rs.next()){
            TB tb = new TB();
            tb.setTB_id(rs.getInt("TB_id"));
            tb.setStudent_id(rs.getInt("student_id"));
            tb.setTeacher_id(rs.getInt("teacher_id"));
            tb.setTB_date(rs.getString("TB_date"));
            tb.setBuilding_id(rs.getInt("building_id"));
            tb.setDomitory_number(rs.getInt("domitory_number"));
            list.add(tb);
        }
        return list;
    }
}
