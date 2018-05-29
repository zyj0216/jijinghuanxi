package Dao;

import entity.Goodslnfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */
public class GoodslnfoImpl extends BaseDAO<Goodslnfo> {
    public List<Goodslnfo> rsToList(ResultSet rs) throws SQLException {
        List<Goodslnfo> list = new ArrayList<Goodslnfo>();
        while (rs.next()){
            Goodslnfo goodslnfo = new Goodslnfo();
            goodslnfo.setGoodsscode(rs.getString("goodsscode"));
            goodslnfo.setEmpno(rs.getInt("empno"));
            goodslnfo.setGoodstyle(rs.getString("goodstyle"));
            goodslnfo.setGoodsunit(rs.getString("goodsunit"));
            goodslnfo.setGoodsname(rs.getString("goodsname"));
            goodslnfo.setGoodsprice(rs.getInt("goodsprice"));
            goodslnfo.setGoodsalarm(rs.getInt("goodsalarm"));
            goodslnfo.setGoodstock(rs.getInt("goodstock"));
            list.add(goodslnfo);
        }
        return list;
    }
}
