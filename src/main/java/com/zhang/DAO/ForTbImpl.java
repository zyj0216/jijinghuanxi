package com.zhang.DAO;

import com.zhang.entity.For_TB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/25.
 */
public class ForTbImpl extends BaseDAO<For_TB> {

    List<For_TB> list=new ArrayList<For_TB>();
    @Override
    public List<For_TB> rsToList(ResultSet rs) throws SQLException {

        while (rs.next()) {
            For_TB for_tb = new For_TB();
            for_tb.setName(rs.getString("student_name"));
            for_tb.setStuclass(rs.getString("student_class"));
            for_tb.setData_tb(rs.getString("TB_date"));
            for_tb.setDomitory_no(rs.getInt("domitory_number"));
            list.add(for_tb);
        }
        return list;
    }

}
