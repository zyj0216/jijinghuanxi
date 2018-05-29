package Dao;

import entity.Purchase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */
public class PurchaseImpl extends BaseDAO<Purchase> {
    public List<Purchase> rsToList(ResultSet rs) throws SQLException {
      List<Purchase> list = new ArrayList<Purchase>();
      while(rs.next()){
          Purchase purchase = new Purchase();
          purchase.setPurchaseid(rs.getInt("purchaseid"));

          purchase.setGoodsname(rs.getString("goodsname"));
          purchase.setPurchasetime(rs.getString("pruchasetime"));
          purchase.setPurchasecount(rs.getInt("purchasecount"));
          purchase.setPurchaseprice(rs.getInt("purchaseprice"));
          purchase.setProvideid(rs.getString("provideid"));
          list.add(purchase);
      }
        return list;
    }
}
