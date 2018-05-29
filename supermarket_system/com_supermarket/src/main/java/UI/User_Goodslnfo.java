package UI;

import entity.Goodslnfo;
import entity.Purchase;
import services.Goodslnfoservice;
import services.Purchaseservice;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/18.
 */
public class User_Goodslnfo {
    Scanner sc = new Scanner(System.in);

    public void Goodslnfo() {
        System.out.println("欢迎来到商品库存管理页面");
        System.out.println("1.查询所有库存商品的详细信息");
        System.out.println("2.根据商品的条码具体查询某一件商品的库存信息");
        System.out.println("3.商品入库");
        System.out.println("4.修改库存商品信息");
        System.out.println("5.删除库存商品");
        System.out.println("6.返回“管理员登录XXX系统");
        System.out.println("7.退出系统");
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
                Manin_five();
                break;
            case 6:
                new Admin_UI().ManagerLogin_over();
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

    Goodslnfoservice goodslnfoservice = new Goodslnfoservice();

    //查询所有库存商品的详细信息
    public void Main_one() {
        List<Goodslnfo> list = goodslnfoservice.select_all();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
        }
        Goodslnfo();
    }

    //根据商品的条码具体查询某一件商品的库存信息
    public void Main_two() {
        System.out.println("请输入要查询商品的条码：");
        String goodsscode = sc.next();
        Goodslnfo goodslnfo = goodslnfoservice.select_Goodsscode(goodsscode);
        if (goodslnfo == null) {
            System.out.println("此商品不存在");
            Main_two();
        } else {
            System.out.println(goodslnfo.toString());
        }
        Goodslnfo();
    }

    //商品入库
    public void Main_three() {
        System.out.println("输入入库的商品条码：");
        String goodsscode = sc.next();
        System.out.println("请输入商品类别：");
        String goodsptype = sc.next();
        System.out.println("请输入商品单位：");
        String goodsuit = sc.next();
        System.out.println("请输入报警数：");
        int goodsalarm = sc.nextInt();
        Purchaseservice purchaseservice = new Purchaseservice();
        Purchase purchase = purchaseservice.selectBy_goodsscode(goodsscode);
        String goodsname = purchase.getGoodsname();
        int goodstock = purchase.getPurchasecount();
        int goodsprice = purchase.getPurchaseprice();
        int num = goodslnfoservice.in_goodsinfo(goodsscode, goodsptype, goodsuit, goodsname, goodsalarm, goodsprice,goodstock);
        if (num > 0) {
            System.out.println("商品入库成功");
        }
    }

    //修改库存商品信息
    public void Main_four() {
        System.out.println("请输入要修改的商品条码：");
        String goodsscode = sc.next();
        System.out.println("请输入更改后的商品名称：");
        String goodsname = sc.next();
        System.out.println("请输入更改后的商品单位：");
        String goodsunit = sc.next();
        if (goodslnfoservice.updateBy_goodsscode(goodsname, goodsunit, goodsscode) > 0) {
            System.out.println("更新成功");
            Goodslnfo();
        } else {
            Main_four();
        }
        Goodslnfo();
    }

    //删除库存商品
    public void Manin_five() {
        System.out.println("请输入要删除的商品条码：");
        String goodsscode = sc.next();
        if ((goodslnfoservice.deleteBy_goodsscode(goodsscode) > 0)) {
            System.out.println("删除成功");
        }
    }


}
