package com.zhang.service;

import com.zhang.DAO.LogOutImpl;
import com.zhang.entity.LogOut;

import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Created by Administrator on 2018/5/24.
 */
public class InOutService {
    LogOutImpl logOutimpl = new LogOutImpl();

    /**
     * 增加一条迁入信息
     */
    public int In_add(int student_id,int admin_id){
        String sql = "insert into logout values(null,?,?,null,null,?,?)";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=df.format(System.currentTimeMillis());
        Object[] objects = new Object[]{student_id,date,admin_id,1};
        return logOutimpl.executeUpdate(sql,objects);
    }

    /**
     * 增加一条迁出信息
     */
    public int Out_add(int student_id,int admin_id){
        String sql = "insert into logout values(null,?,null,?,null,?,?)";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=df.format(System.currentTimeMillis());
        Object[] objects = new Object[]{student_id,date,admin_id,0};
        return logOutimpl.executeUpdate(sql,objects);
    }

    /**
     * 查询所有的迁出记录
     */
    public List<LogOut> selectAll_outMsg(int LogOut_type){
        String sql = "select * from logout where LogOut_type=?";
        Object[] objects=new Object[]{LogOut_type};
        return logOutimpl.executeQuery(sql,objects);
    }
}
