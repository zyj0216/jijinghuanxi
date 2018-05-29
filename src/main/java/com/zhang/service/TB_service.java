package com.zhang.service;

import com.zhang.DAO.TBImpl;
import com.zhang.entity.TB;

import java.util.List;

/**
 * Created by Administrator on 2018/5/25.
 */
public class TB_service {

    TBImpl tbimpl=new TBImpl();
    /**
     * 系统管理员查询某一个学生的缺寝信息
     */
    public TB select_Byadmin(int student_id,int building_id,int domitory_number){
        String sql  = "select * from tb where student_id=? and building_id=? and domitory_number=?";
        Object[] objects = new Object[]{student_id,building_id,domitory_number};
        List<TB> list = tbimpl.executeQuery(sql,objects);
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    /**
     * 查询所有缺勤休息
     */
    public List<TB> selectAll(){
        String sql = "select * from tb";
        Object[] objects = null;
        return tbimpl.executeQuery(sql,objects);
    }
}
