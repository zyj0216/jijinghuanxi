package UI;

import entity.Salesdetail;
import services.Salesdetailservice;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/18.
 */
public class User_SalesDetail {
    Scanner sc = new Scanner(System.in);
    public void SalesDetail(){
        System.out.println("欢迎来到商品销售报表管理页面");
        System.out.println("1.查询所有的商品销售明细");
        System.out.println("2.返回主菜单");
        System.out.println("3.返回“管理员登录XXX系统");
        System.out.println("4.退出系统");
        System.out.println("请输入所要选择的序号:");
        switch (sc.nextInt()) {
            case 1:
                Main_one();
                break;
            case 2:
                SalesDetail();
                break;
            case 3:
                new Admin_UI().ManagerLogin_over();
                break;
            case 4:
                //退出登录
                System.out.println("谢谢使用！！！");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    Salesdetailservice salesdetailservice = new Salesdetailservice();
    //查询所有商品销售明细
    public void Main_one(){
        List<Salesdetail> list = salesdetailservice.select();
        if (list.size()>0){
            for (int i=0;i<list.size();i++){
                System.out.println(list.get(i).toString());
            }
        }
        SalesDetail();
    }


}
