package com.zhang.service;

import com.zhang.DAO.TeacherImpl;
import com.zhang.entity.Teacher;

import java.util.List;

/**
 * Created by Administrator on 2018/5/17.
 */
public class TeacherService {
    private TeacherImpl teacherimpl = new TeacherImpl();
    /**
     * 用户名和密码登录
     */
    public Teacher CheckLogin(String teacher_uname, String teacher_password) {
        String sql = "select * from admin where teacher_uname=? and teacher_password=?";
        Object[] objects = new Object[]{teacher_uname, teacher_password};
        List<Teacher> list = teacherimpl.executeQuery(sql, objects);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 查询所有楼宇管理员
     */
    public List<Teacher> selectAll(){
        String sql = "select * from teacher";
        Object[] objects = null;
        return teacherimpl.executeQuery(sql,objects);
    }

    /**
     * 删除楼宇管理员
     */
    public int deleteTeacherByID(int teacher_id){
        String sql = "delete from teacher where teacher_id=?";
        Object[] objects = new Object[]{teacher_id};
        return teacherimpl.executeUpdate(sql,objects);
    }

    /**
     * 添加楼宇管理员
     */
    public int add_teacher(Teacher teacher){
        String sql = "insert into teacher values(null,?,?,?,?,?,?)";
        Object[] objects = new Object[]{
                teacher.getTeacher_uname(),
                teacher.getTeacher_password(),
                teacher.getTeacher_name(),
                teacher.getTeacher_sex(),
                teacher.getTeacher_tel(),
                teacher.getBuilding_id()
        };
        return teacherimpl.executeUpdate(sql,objects);
    }

    /**
     * 根据项查询
     */
    public List<Teacher> selectBy_OptionVlues(String option,String values){
        String sql = "select * from teacher where "+option+"=?";
        Object[] objects = new Object[]{values};
        return teacherimpl.executeQuery(sql,objects);
    }

    /**
     * 根据用户名查询
     */
    public Teacher selectByUname(String teacher_id){
        String sql = "select * from teacher where teacher_id=?";
        Object[] objects = new Object[]{teacher_id};
        List<Teacher> list = teacherimpl.executeQuery(sql,objects);
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    /**
     * 修改楼宇管理员信息
     */
    public int update(Teacher teacher){
        String sql="update teacher set teacher_uname=?,teacher_password=?,teacher_name=?,teacher_sex=?," +
                "teacher_tel=?,building_id=? where teacher_id=?";
        Object[] objects=new Object[]{
                teacher.getTeacher_uname(),
                teacher.getTeacher_password(),
                teacher.getTeacher_name(),
                teacher.getTeacher_sex(),
                teacher.getTeacher_tel(),
                teacher.getBuilding_id(),
                teacher.getTeacher_id()
        };
        return teacherimpl.executeUpdate(sql,objects);
    }

    /**
     * 根据楼宇号查询楼宇管理员
     */
    public List<Teacher> selectByBuilding_ID(int building_id){
        String sql = "select * from teacher where building_id=?";
        Object[] objects = new Object[]{building_id};
        return teacherimpl.executeQuery(sql,objects);
    }


}
