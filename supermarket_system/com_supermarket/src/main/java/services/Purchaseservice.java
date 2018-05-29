package services;

import Dao.PurchaseImpl;
import entity.Purchase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/20.
 */
public class Purchaseservice {
    PurchaseImpl purchaseimpl = new PurchaseImpl();

    //查询所有历史采购信息
    public List<Purchase> select() {
        String sql = "select * from Purchase";
        List<Purchase> list = purchaseimpl.executeQuery(sql, null);
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    //根据商品条码查询某一件商品的采购信息
    public Purchase selectBy_goodsscode(String goodsscode) {
        String sql = "select * from Purchase where goodsscode=?";
        Object[] objects = new Object[]{goodsscode};
        List<Purchase> list = purchaseimpl.executeQuery(sql, objects);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    //插入生成采购记录
    public int insert(String goodsscode,String goodsname,int purchasecount,int purchaseprice,int purchaseid){
        int Flag = -1;
        String sql = "insert into Purchase values(?,?,?,?,?,?,?)";
        Date date = new Date();
        Object[] objects = new Object[]{null,goodsscode,goodsname,date,purchasecount,purchaseprice,purchaseid};
        Flag = purchaseimpl.executeUpdate(sql,objects);
        return Flag;
    }


}
