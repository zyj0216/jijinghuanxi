package services;

import Dao.EmployeelnfoImpl;
import entity.Employeelnfo;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */
public class Employeelnfoservice {
    private EmployeelnfoImpl employeelnfoimpl = new EmployeelnfoImpl();

    //用账号和密码登录
    public Employeelnfo select_Login(String account, String password) {
        String sql = "select * from Employeelnfo where account=? and password=?";
        Object[] objects = new Object[]{account, password};
        List<Employeelnfo> list = employeelnfoimpl.executeQuery(sql, objects);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    //查询所有员工信息
    public List<Employeelnfo> select_all() {
        String sql = "select * from Employeelnfo";
        List<Employeelnfo> list = employeelnfoimpl.executeQuery(sql, null);
        return list;

    }

    //根据员工编号查询员工信息
    public Employeelnfo selectBy_empno(int empno) {
        String sql = "select * from Employeelnfo where empno=? ";
        Object[] objects = new Object[]{empno};
        List<Employeelnfo> list = employeelnfoimpl.executeQuery(sql, objects);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    //修改员工信息
    public int updateBY_empno(String phone,int empno) {
        int Flag = -1;
        String sql = "update Employeelnfo set phone=? where empno=?";
        Object[] objects = new Object[]{phone,empno};
        Flag = employeelnfoimpl.executeUpdate(sql,objects);
        return Flag;
    }

    //新增员工信息
    public int insert(String ename, String sex, String account, String phone, String password, int isadmin){
        int Flag = -1;
        String sql = "insert into Employeelnfo values(?,?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{null,ename,sex,account,phone,password,isadmin,null};
        Flag = employeelnfoimpl.executeUpdate(sql,objects);
        return Flag;
    }


    //删除员工信息
    public int delete(int empno){
        int Flag=-1;
        String sql = "delete from Employeelnfo where empno=?";
        Object[] objects = new Object[]{empno};
        Flag = employeelnfoimpl.executeUpdate(sql,objects);
        return Flag;
    }





}
