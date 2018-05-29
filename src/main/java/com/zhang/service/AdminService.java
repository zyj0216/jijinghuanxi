package com.zhang.service;

import com.zhang.DAO.AdminImpl;
import com.zhang.entity.Admin;

import javax.xml.soap.SAAJResult;
import java.util.List;

/**
 * Created by Administrator on 2018/5/17.
 */
public class AdminService {
    private AdminImpl adminimpl = new AdminImpl();
    /**
     * 用户名和密码登录
     */
    public Admin CheckLogin(String admin_username,String admin_password){
        String sql = "select * from admin where admin_username=? and admin_password=?";
        Object[] objects = new Object[]{admin_username,admin_password};
        List<Admin> list = adminimpl.executeQuery(sql ,objects);
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    /**
     * 查询所有系统管理员用户
     */
    public List<Admin> selectAll(){
        String sql = "select * from admin";
        Object[] objects = null;
        return adminimpl.executeQuery(sql,objects);
    }

    /**
     * 修改密码
     */

    public Admin getpwdByID(int id){
        String sql = "select * from admin where admin_id=?";
        Object[] objects = new Object[]{id};
        List<Admin> list = adminimpl.executeQuery(sql ,objects);
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }


    public int update(String newPassword,int id){
        String sql = "update admin set admin_password=? where admin_id=?";
        Object[] objects = new Object[]{newPassword,id};
        return adminimpl.executeUpdate(sql,objects);
    }


}
