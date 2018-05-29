package Dao;

import entity.Employeelnfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */
public class EmployeelnfoImpl extends BaseDAO<Employeelnfo> {
    public List<Employeelnfo> rsToList(ResultSet rs) throws SQLException {
       List<Employeelnfo> list = new ArrayList<Employeelnfo>();
       while(rs.next()){
           Employeelnfo employeelnfo = new Employeelnfo();
           employeelnfo.setEname(rs.getString("ename"));
           employeelnfo.setSex(rs.getString("sex"));
           employeelnfo.setAccount(rs.getString("account"));
           employeelnfo.setPhone(rs.getString("phone"));
           employeelnfo.setPassword(rs.getString("password"));
           employeelnfo.setIsadmin(rs.getInt("isadmin"));
           employeelnfo.setIsenable(rs.getInt("isenable"));
           list.add(employeelnfo);
       }
        return list;
    }
}
