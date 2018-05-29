package com.zhang.service;

import com.zhang.DAO.ForTbImpl;
import com.zhang.entity.For_TB;

import java.util.List;

/**
 * Created by Administrator on 2018/5/25.
 */
public class For_tbService {
    ForTbImpl forTbimpl=new ForTbImpl();

    /**
     * 查询所有
     */
    public List<For_TB> select(){
        String sql = "select s.domitory_number,s.student_name,s.student_class,t.TB_date from student s,tb t where t.student_id=s.student_id";
        Object[] objects = null;
        return forTbimpl.executeQuery(sql,objects);
    }
}
