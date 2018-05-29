package Dao;

import entity.Purchase;

import java.sql.*;
import java.util.List;

/**
 * Created by Administrator on 2018/4/27.
 */
public class procedureimpl extends BaseDAO<Purchase> {

    public String create_purchase(String goodsscode, String goodsname, int purchasecount, double purchaseprice, int provideid) {
        String msgtr = "";
        Connection conn = this.openConnection();
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call pro_create_purchase(?,?,?,?,?,?)}");
            cs.setString(1, goodsscode);
            cs.setString(2, goodsname);
            cs.setInt(3,purchasecount);
            cs.setDouble(4, purchaseprice);
            cs.setInt(5,provideid);
            cs.registerOutParameter(6, Types.VARCHAR);
            cs.execute();
            return cs.getString(6);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if (null!=conn){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return msgtr;
    }


    public List<Purchase> rsToList(ResultSet rs) throws SQLException {
        return null;
    }
}
