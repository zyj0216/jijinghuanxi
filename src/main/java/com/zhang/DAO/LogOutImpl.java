package com.zhang.DAO;

import com.zhang.entity.LogOut;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/17.
 */
public class LogOutImpl extends BaseDAO<LogOut> {
    @Override
    public List<LogOut> rsToList(ResultSet rs) throws SQLException {
        List<LogOut> list = new ArrayList<LogOut>();
        while (rs.next()){
            LogOut logOut = new LogOut();
            logOut.setLogout_id(rs.getInt("logout_id"));
            logOut.setStudent_id(rs.getInt("student_id"));
            logOut.setStudent_name(rs.getString("student_name"));
            logOut.setStudent_class(rs.getString("student_class"));
            logOut.setLog_date(rs.getString("log_date"));
            logOut.setOut_date(rs.getString("out_date"));
            logOut.setAdmin_id(rs.getInt("admin_id"));
            logOut.setLog_remark(rs.getString("log_remark"));
            logOut.setLogOut_type(rs.getInt("LogOut_type"));
            list.add(logOut);
        }
        return list;
    }
}
