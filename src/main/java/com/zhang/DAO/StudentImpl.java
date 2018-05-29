package com.zhang.DAO;

import com.zhang.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/17.
 */
public class StudentImpl extends BaseDAO<Student> {
    @Override
    public List<Student> rsToList(ResultSet rs) throws SQLException {
        List<Student> list = new ArrayList<Student>();
        while (rs.next()){
            Student student = new Student();
            student.setStudent_id(rs.getInt("student_id"));
            student.setDomitory_number(rs.getInt("domitory_number"));
            student.setTeacher_id(rs.getInt("teacher_id"));
            student.setBuilding_id(rs.getInt("building_id"));
            student.setStudent_name(rs.getString("student_name"));
            student.setStudent_password(rs.getString("student_password"));
            student.setStudent_username(rs.getString("student_username"));
            student.setStudent_tel(rs.getString("student_tel"));
            student.setStudent_class(rs.getString("student_class"));
            student.setStudent_state(rs.getString("student_state"));
            list.add(student);
        }
        return list;
    }
}
