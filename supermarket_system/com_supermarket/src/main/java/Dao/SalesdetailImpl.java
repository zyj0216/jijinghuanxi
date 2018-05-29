package Dao;

import entity.Salesdetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */
public class SalesdetailImpl extends BaseDAO<Salesdetail> {
    public List<Salesdetail> rsToList(ResultSet rs) throws SQLException {
      List<Salesdetail> list = new ArrayList<Salesdetail>();
      while(rs.next()){
          Salesdetail salesdetail = new Salesdetail();
          salesdetail.setDetailid(rs.getInt("detailid"));
          salesdetail.setEmpno(rs.getInt("empno"));
          salesdetail.setGoodscode(rs.getString("goodsscode"));
          salesdetail.setGoodsname(rs.getString("goodsname"));
          salesdetail.setCount(rs.getInt("count"));
          salesdetail.setUnitprice(rs.getInt("unitprice"));
          salesdetail.setSumprice(rs.getInt("sumprice"));
          salesdetail.setSaledate(rs.getString("saledate"));
          list.add(salesdetail);
      }
        return list;
    }
}
