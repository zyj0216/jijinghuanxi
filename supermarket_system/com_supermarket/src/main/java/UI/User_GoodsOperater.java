package UI;

import entity.Employeelnfo;
import entity.Goodslnfo;
import entity.Goodsoperater;
import services.Goodslnfoservice;
import services.Goodsoperaterservice;
import services.Purchaseservice;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/18.
 */
public class User_GoodsOperater {
    Scanner sc = new Scanner(System.in);

    public void GoodsOperater() {
        System.out.println("欢迎来到商品上下架管理页面");
        System.out.println("1.上架商品");
        System.out.println("2.下架商品");
        System.out.println("3.查询所有记录（上下架记录）");
        System.out.println("4.返回“管理员登录XXX系统");
        System.out.println("5.退出系统");
        System.out.println("请输入所要选择的序号:");
        switch (sc.nextInt()) {
            case 1:
                Mian_one();
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

    Goodsoperaterservice goodsoperaterservice = new Goodsoperaterservice();
    Goodslnfoservice goodslnfoservice = new Goodslnfoservice();

    /**
     * 上架商品
     */

    //首先系统自动提示库存情况
    public void Mian_one() {
        List<Goodslnfo> list = goodslnfoservice.select_all();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getGoodsalarm() >= list.get(i).getGoodstock()) {
                System.err.println(list.get(i).getGoodsname() + "数量不足，请及时采购~~~~");
            }
        }
        System.out.println("库存充足，请放心上架商品！！！！！");
        //显示有哪些商品可以上架
        System.out.println("库存中有如下商品可进行上架操作：");
        System.out.println("商品条码" + "商品名称" + "商品单位");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getGoodsalarm() < list.get(i).getGoodstock()) {
                System.out.println(list.get(i).getGoodsscode() + list.get(i).getGoodsname() + list.get(i).getGoodsunit());
            }
        }
        //进行上架操作
        //商品上架完成后，库存表中该商品的数量要更新，保证上架数量+库存数量=采购数量；
        System.out.println("请输入要上架的商品条码：");
        String goodsscode = sc.next();
        System.out.println("请输入要上架的商品数量：");
        int upcount = sc.nextInt();
        System.out.println("请输入商品名称：");
        String goodsname = sc.next();
        System.out.println("请输入要上架的商品价格：");
        int onsaleprice = sc.nextInt();
        if (goodsoperaterservice.up_product(goodsscode, goodsname, onsaleprice, upcount) > 0) {
            System.out.println("商品上架成功");
        } else {
            Mian_one();
        }
        Goodslnfo goodslnfo = goodslnfoservice.select_Goodsscode(goodsscode);
        int goodstock = (goodslnfo.getGoodstock()-upcount);
        if (goodslnfoservice.updatecount_Byupproduct(goodsscode,goodstock)>0){
            System.out.println("数据更新成功");
        }
        GoodsOperater();
    }

    //商品下架
    public void Main_two(){
        System.out.println("请输入要下架的商品条码：");
        String goodsscode = sc.next();
        System.out.println("请输入要下架的商品数量：");
        int downcount = sc.nextInt();
        Goodslnfo goodslnfo = goodslnfoservice.select_Goodsscode(goodsscode);
        int onsaleprice = goodslnfo.getGoodsprice();//价格
        String goodsname = goodslnfo.getGoodsname();
        if(goodsoperaterservice.up_product(goodsscode,goodsname,onsaleprice,downcount)>0){
            System.out.println("商品下架成功");
        }else{
            Main_two();
        }
        Goodslnfo goodslnfo1 = goodslnfoservice.select_Goodsscode(goodsscode);
        int goodstock = goodslnfo1.getGoodstock()+downcount;
        if (goodslnfoservice.updatecount_Byupproduct(goodsscode,goodstock)>0){
            System.out.println("数据更新成功");
        }
        GoodsOperater();
    }

    //查询所有记录（上下架记录）
    public void Main_three() {
        List<Goodsoperater> list = goodsoperaterservice.select_all();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
        }
        GoodsOperater();
    }


}
