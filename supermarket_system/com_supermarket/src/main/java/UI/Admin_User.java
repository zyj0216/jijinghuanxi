package UI;

import entity.Employeelnfo;
import services.Employeelnfoservice;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/18.
 */
public class Admin_User {
    private Scanner sc = new Scanner(System.in);
    private Employeelnfoservice employeelnfoservice = new Employeelnfoservice();
    public static int empno;

    public void Admin_User_Login() {
        System.out.println("欢迎登录XXX用户管理系统：");
        System.out.println("1.登录");
        System.out.println("2.退出");
        System.out.println("请输入你的选择序号：");
        switch (sc.nextInt()) {
            case 1:
                main_one();
                break;
            case 2:
                System.out.println("谢谢使用！！！");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public void main_one() {
        System.out.println("请输入账号：");
        String account = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        Employeelnfo employeelnfo = employeelnfoservice.select_Login(account, password);
        empno = employeelnfo.getEmpno();
        if (employeelnfo == null) {
            System.err.println("你输入的用户名或者密码错误~~~~");
            main_one();
        } else {
            if (employeelnfo.getIsadmin() == 1) {
                new Admin_UI().ManagerLogin_over();
            } else {
                new User_UI().UserLogin_over();
            }
        }


    }

}
