package UI;

import entity.Goodslnfo;
import javafx.scene.chart.PieChart;
import services.Attencelnfoservice;
import services.Goodslnfoservice;
import services.Salesdetailservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/18.
 */
public class User_UI {
    private Scanner sc = new Scanner(System.in);

    public void UserLogin_over() {
        System.out.println("欢迎收银员登录XXX系统");
        System.out.println("1.商品结算");
        System.out.println("2.上班打卡");
        System.out.println("3.下班打卡");
        System.out.println("4.返回主菜单");
        System.out.println("5.退出");
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
                //返回主菜单
                UserLogin_over();
                break;
            case 5:
                //退出登录
                System.out.println("谢谢使用！！！");
                System.exit(0);
                break;
        }
    }

    Attencelnfoservice attencelnfoservice = new Attencelnfoservice();
    Goodslnfoservice goodslnfoservice = new Goodslnfoservice();
    Salesdetailservice salesdetailservice = new Salesdetailservice();


    //商品结算
    public void Main_one(){
        System.out.println("请输入要查询商品的条码：");
        String goodsscode = sc.next();
        Goodslnfo goodslnfo = goodslnfoservice.select_Goodsscode(goodsscode);
        String goodsname = goodslnfo.getGoodsname();
        System.out.println("请输入要购买的商品数量：");
        int num = sc.nextInt();
        int unitprice = goodslnfo.getGoodsprice();
        System.out.println(unitprice);
        int sumprice = (unitprice*num);
        System.out.println(sumprice);
        if(salesdetailservice.insert(goodsscode,goodsname,num,unitprice,sumprice)>0){
            System.out.println("********购物清单********");
            System.out.println("名称"+"\t "+"数量"+"\t "+"单价"+"\t "+"总价");
            System.out.println(goodsname+"\t\t"+num+"\t\t"+unitprice+"\t\t"+sumprice);
            System.out.println("欢迎下次光临！！！！");
        }

        int goodstock = goodslnfo.getGoodstock()-num;
        if (goodslnfoservice.updatecount_Bysales(goodsscode,goodstock)>0){
            System.out.println("数据更新完成！！！！");
        }
    }

    //上班打卡
    public void Main_two() {
        System.out.println("欢迎进入打卡系统~~~~~");
        System.out.println("请输入员工编号：");
        int empno = sc.nextInt();
        if (attencelnfoservice.onduty(empno) > 0) {
            System.out.println("上班打卡成功");
        }else {
            System.err.println("打卡失败");
            Main_two();
        }
        UserLogin_over();
    }

    //下班打卡
    public void Main_three(){
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
        UserLogin_over();
    }


}
