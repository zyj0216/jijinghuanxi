package UI;

import entity.Attencelnfo;
import entity.Employeelnfo;
import services.Attencelnfoservice;
import services.Employeelnfoservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/18.
 */
public class User_Employeelnfo {
    private Scanner sc = new Scanner(System.in);

    public void Employeelnfo() {
        System.out.println("欢迎来到用户管理界面");
        System.out.println("1.查询所有用户信息");
        System.out.println("2.根据员工编号查询员工信息");
        System.out.println("3.修改员工信息");
        System.out.println("4.新增员工信息");
        System.out.println("5.删除员工信息");
        System.out.println("6.查看收银员考勤情况");
        System.out.println("7.上班打卡");
        System.out.println("8.下班打卡");
        System.out.println("9.返回“管理员登录XXX系统");
        System.out.println("10.退出系统");
        System.out.println("请输入所要选择的序号:");
        switch (sc.nextInt()) {
            case 1:
                Main_one();
                break;
            case 2:
                Main_two();
                break;
            case 3:
                Main_three();
                break;
            case 4:
                Main_four();
                break;
            case 5:
                Main_five();
                break;
            case 6:
                Main_six();
                break;
            case 7:
                Main_seven();
                break;
            case 8:
                Main_eigth();
                break;
            case 9:
                new Admin_UI().ManagerLogin_over();
                break;
            case 10:
                //退出登录
                System.out.println("谢谢使用！！！");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    Employeelnfoservice employeelnfoservice = new Employeelnfoservice();

    //查询所有用户信息
    public void Main_one() {
        List<Employeelnfo> list = employeelnfoservice.select_all();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
            Employeelnfo();
        }
    }

    public void Main_two() {
        System.out.println("请输入员工编号：");
        int empno = sc.nextInt();
        Employeelnfo employeelnfo = employeelnfoservice.selectBy_empno(empno);
        if (employeelnfo == null) {
            System.out.println("员工编号输入错误");
            Main_two();
        } else {
            System.out.println(employeelnfo.toString());
        }
        Employeelnfo();
    }

    //根据员工编号查询员工修改员工信息
    public void Main_three() {
        System.out.println("请输入员工编号：");
        int empno = sc.nextInt();
        System.out.println("请输入员工新的电话：");
        String phone = sc.next();
        int num = employeelnfoservice.updateBY_empno(phone, empno);
        if (num > 0) {
            System.out.println("修改成功");
        }
        Employeelnfo();
    }

    //新增员工信息
    public void Main_four() {
        System.out.println("请输入员工的姓名：");
        String ename = sc.next();
        System.out.println("请输入员工的性别：");
        String sex = sc.next();
        System.out.println("请输入员工的账号：");
        String account = sc.next();
        System.out.println("请输入员工的电话：");
        String phone = sc.next();
        System.out.println("请输入员工的密码：");
        String password = sc.next();
        System.out.println("请输入员工是否是管理员：");
        int isadmin = sc.nextInt();
        int num = employeelnfoservice.insert(ename, sex, account, phone, password, isadmin);
        if (num > 0) {
            System.out.println("新增信息成功！！");
        }
        Employeelnfo();
    }

    //删除员工信息
    public void Main_five() {
        System.out.println("输入要删除员工的编号：");
        int empno = sc.nextInt();
        int num = employeelnfoservice.delete(empno);
        if (num>0){
            System.out.println("删除成功！");
        }
    }


    Attencelnfoservice attencelnfoservice = new Attencelnfoservice();
    //查看收银员考勤情况
    public void Main_six() {
        List<Attencelnfo> list = attencelnfoservice.select_all();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.toString());
            }
        }
    }

    //上班打卡
    public void Main_seven() {
        System.out.println("欢迎进入打卡系统~~~~~");
        System.out.println("请输入员工编号：");
        int empno = sc.nextInt();
        if (attencelnfoservice.onduty(empno) > 0) {
            System.out.println("上班打卡成功");
        }else {
            System.err.println("打卡失败");
            Main_two();
        }
        Employeelnfo();
    }

    //下班打卡
    public void Main_eigth(){
        System.out.println("请输入员工编号：");
        int empno = sc.nextInt();
        Date date = new Date();
        String d = new SimpleDateFormat().format(date);
        if (attencelnfoservice.outdaty(empno,d)>0) {
            System.out.println("下班打卡成功");
        }else {
            System.err.println("打卡失败");
            Main_two();
        }
        Employeelnfo();
    }


}








