package UI;

import Dao.procedureimpl;
import entity.Purchase;
import services.Purchaseservice;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/18.
 */
public class User_Purchase {
    Scanner sc = new Scanner(System.in);

    public void Purchase() {
        System.out.println("欢迎来到商品采购管理页面");
        System.out.println("1.查询所有历史采购信息");
        System.out.println("2.根据商品条码查询某一件商品的采购信息");
        System.out.println("3.插入生成采购记录");
        System.out.println("4.返回“管理员登录XXX系统");
        System.out.println("5.退出系统");
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
                new Admin_UI().ManagerLogin_over();
                break;
            case 5:
                //退出登录
                System.out.println("谢谢使用！！！");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    Purchaseservice purchaseservice = new Purchaseservice();

    //查询所有历史采购信息
    public void Main_one() {
        List<Purchase> list = purchaseservice.select();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
        }
        Purchase();
    }

    //根据商品条码查询某一件商品的采购信息
    public void Main_two() {
        System.out.println("输入商品条码：");
        String goodsscode = sc.next();
        Purchase purchase = purchaseservice.selectBy_goodsscode(goodsscode);
        if (purchase==null){
            System.out.println("商品条码输入错误");
            Main_two();
        }else {
            System.out.println(purchase.toString());
        }
        Purchase();
    }

    //插入生成采购记录
    public void Main_three(){
//        System.out.println("输入采购的商品条码：");
//        String goodsscode = sc.next();
//        System.out.println("输入采购的商品名称：");
//        String goodsname = sc.next();
//        System.out.println("输入采购的商品数量：");
//        int purchasecount = sc.nextInt();
//        System.out.println("输入采购的商品价格：");
//        int purchaseprice = sc.nextInt();
//        System.out.println("输入采购的商品数量：");
//        int purchaseid = sc.nextInt();
//        if (purchaseservice.insert(goodsscode,goodsname,purchasecount,purchaseprice,purchaseid)>0){
//            System.out.println("采购记录插入成功");
//        }else {
//            Main_three();
//        }
//        Purchase();


        procedureimpl pro = new procedureimpl();
        String aa = pro.create_purchase("kkk","奶茶",150,3,2);
        System.out.println(aa);
    }



}
