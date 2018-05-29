package com.zhang.service;

import com.zhang.DAO.StudentImpl;
import com.zhang.entity.Student;

import java.util.List;

/**
 * Created by Administrator on 2018/5/17.
 */
public class StudentService  {
    private StudentImpl studentimpl = new StudentImpl();
    /**
     * 用户名和密码登录
     */
    public Student CheckLogin(String student_username,String student_password){
        String sql = "select * from admin where student_username=? and student_password=?";
        Object[] objects = new Object[]{student_username,student_password};
        List<Student> list = studentimpl.executeQuery(sql ,objects);
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    /**
     * 查询所有
     */
    public List<Student> selectAll(){
        String sql = "select * from student";
        Object[] objects = null;
        return studentimpl.executeQuery(sql,objects);
    }

    /**
     * 添加学生
     */
    public int addStudent(Student student){
        String sql = "insert into student values(null,?,?,?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{
           student.getDomitory_number(),
           student.getBuilding_id(),
           student.getStudent_username(),
           student.getStudent_password(),
           student.getStudent_name(),
           student.getStudent_tel(),
           student.getStudent_class(),
           student.getStudent_state(),
           student.getTeacher_id()
        };
        return studentimpl.executeUpdate(sql,objects);
    }

    /**
     * 根据id查询某一个学生
     */
    public Student selectStudentBy_ID(int student_id){
        String sql = "select * from student where student_id=?";
        Object[] objects = new Object[]{student_id};
        List<Student> list = studentimpl.executeQuery(sql,objects);
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    /**
     * 删除学生
     */
    public int deleteStudentBy_ID(int student_id){
        String sql = "delete from student where student_id=?";
        Object[] objects = new Object[]{student_id};
        return studentimpl.executeUpdate(sql,objects);
    }

    /**
     * 根据是否入住状态查询
     */
    public List<Student> selectStudentBy_state(int student_state){
        String sql = "select * from student where student_state=?";
        Object[] objects = new Object[]{student_state};
        return studentimpl.executeQuery(sql,objects);
    }

    /**
     * 根据项查询(值为String)
     */
    public List<Student> selectStudentBy_Option(String option,String values){
        String sql = "select * from student where "+option+"=?";
        Object[] objects = new Object[]{values};
        return studentimpl.executeQuery(sql,objects);
    }

    /**
     * 根据项查询(值为int)
     */

    public List<Student> selectStudentBy_Option(String option,int values){
        String sql = "select * from student where "+option+"=?";
        Object[] objects = new Object[]{values};
        return studentimpl.executeQuery(sql,objects);
    }

    /**
     * 修改学生
     */
    public int updateStudebtBy(Student student){
        String sql = "update student set domitory_number=?,teacher_id=?,building_id=?,student_username=?,student_password=?,student_name=?,student_tel=?,student_class=?,student_state=? where student_id=?";
        Object[] objects = new Object[]{
                student.getDomitory_number(),
                student.getTeacher_id(),
                student.getBuilding_id(),
                student.getStudent_username(),
                student.getStudent_password(),
                student.getStudent_name(),
                student.getStudent_tel(),
                student.getStudent_class(),
                student.getStudent_state(),
                student.getStudent_id()
        };
        return studentimpl.executeUpdate(sql,objects);
    }

    /**
     * 学生迁入迁出时信息的修改
     */
    //迁入时的信息修改
    public int updataByIn(int domitory_number,int building_id,int student_id){
        String sql = "update student set domitory_number=?,building_id=?,student_state=? where student_id=?";
        Object[] objects=new Object[]{domitory_number,building_id,1,student_id};
        return studentimpl.executeUpdate(sql,objects);
    }

    /**
     * 学生调寝后信息修改
     */
    public int change_domitoryAfter(int domitory_number,int building_id,int student_id){
        String sql = "update student set domitory_number=?,building_id where student_id=?";
        Object[] objects=new Object[]{domitory_number,building_id,student_id};
        return studentimpl.executeUpdate(sql,objects);
    }
}
