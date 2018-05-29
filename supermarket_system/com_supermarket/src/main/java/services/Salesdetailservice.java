package services;

import Dao.SalesdetailImpl;
import entity.Salesdetail;

import java.util.Date;
import java.util.List;

import static UI.Admin_User.empno;

/**
 * Created by Administrator on 2018/4/21.
 */
public class Salesdetailservice {
   SalesdetailImpl salesdetail = new SalesdetailImpl();

   //生成购物信息
    public int insert(String goodsscode, String goodsname,int num,int unitprice,int sumprice){
        int Flag = -1;
        Date date = new Date();
        String sql = "insert into Salesdetail values(?,?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{null,empno,goodsscode,goodsname,num,unitprice,sumprice,date};
        Flag = salesdetail.executeUpdate(sql,objects);
        return Flag;
    }

    //查看所有商品销售明细
    public List<Salesdetail> select(){
        String sql = "select * from Salesdetail";
        List<Salesdetail> list = salesdetail.executeQuery(sql,null);
        if (list.size()>0){
            return list;
        }else {
            return null;
        }
    }
}
