package com.zhang.DAO;

import com.zhang.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/17.
 */
public class AdminImpl extends BaseDAO<Admin> {
    @Override
    public List<Admin> rsToList(ResultSet rs) throws SQLException {
        List<Admin> list = new ArrayList<Admin>();
        while (rs.next()){
            Admin admin = new Admin();
            admin.setAdmin_id(rs.getInt("admin_id"));
            admin.setAdmin_username(rs.getString("admin_username"));
            admin.setAdmin_password(rs.getString("admin_password"));
            admin.setAdmin_name(rs.getString("admin_name"));
            admin.setAdmin_sex(rs.getString("admin_sex"));
            admin.setAdmin_tel(rs.getString("admin_tel"));
            list.add(admin);
        }
        return list;
    }
}
