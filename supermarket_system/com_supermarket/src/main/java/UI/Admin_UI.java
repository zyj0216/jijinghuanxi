package UI;

import java.util.Scanner;

import static UI.Admin_User.empno;

/**
 * Created by Administrator on 2018/4/18.
 */
public class Admin_UI {
    private Scanner sc = new Scanner(System.in);

    public void ManagerLogin_over() {

        System.out.println("欢迎"+empno+"管理员登录XXX系统");
        System.out.println("1.用户管理");
        System.out.println("2.商品上下架管理");
        System.out.println("3.商品库存管理");
        System.out.println("4.商品采购记录管理");
        System.out.println("5.商品销售报表管理");
        System.out.println("6.返回登录菜单");
        System.out.println("7.退出登录");
        System.out.println("请输入所要选择的序号:");
        switch (sc.nextInt()) {
            case 1:
                new User_Employeelnfo().Employeelnfo();
                break;
            case 2:
                new User_GoodsOperater().GoodsOperater();
                break;
            case 3:
               new User_Goodslnfo().Goodslnfo();
                break;
            case 4:
                new User_Purchase().Purchase();
                break;
            case 5:
                new User_SalesDetail().SalesDetail();
                break;
            case 6:
                //返回登录菜单
               new Admin_User().Admin_User_Login();
                break;
            case 7:
                //退出登录
                System.out.println("谢谢使用！！！");
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
