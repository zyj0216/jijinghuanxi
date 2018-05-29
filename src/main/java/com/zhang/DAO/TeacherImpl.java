package com.zhang.DAO;

import com.zhang.entity.Teacher;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/17.
 */
public class TeacherImpl extends BaseDAO<Teacher>{

    @Override
    public List<Teacher> rsToList(ResultSet rs) throws SQLException {
        List<Teacher> list = new ArrayList<Teacher>();
        while (rs.next()){
            Teacher teacher = new Teacher();
            teacher.setTeacher_id(rs.getInt("teacher_id"));
            teacher.setTeacher_name(rs.getString("teacher_name"));
            teacher.setTeacher_password(rs.getString("teacher_password"));
            teacher.setTeacher_uname(rs.getString("teacher_uname"));
            teacher.setTeacher_sex(rs.getString("teacher_sex"));
            teacher.setTeacher_tel(rs.getString("teacher_tel"));
            teacher.setBuilding_id(rs.getInt("building_id"));
            list.add(teacher);
        }
        return list;
    }
}
