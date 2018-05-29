package Dao;

import entity.Goodsoperater;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */
public class GoodsoperaterImpl extends BaseDAO<Goodsoperater> {
    public List<Goodsoperater> rsToList(ResultSet rs) throws SQLException {
        List<Goodsoperater> list = new ArrayList<Goodsoperater>();
        while(rs.next()){
            Goodsoperater goodsoperater = new Goodsoperater();
            goodsoperater.setGoodsoperaterid(rs.getInt("goodsoperaterid"));
            goodsoperater.setEmpno(rs.getInt("empno"));
            goodsoperater.setGoodsscode(rs.getString("goodsscode"));
            goodsoperater.setGoodsname(rs.getString("goodsname"));
            goodsoperater.setOnsaledate(rs.getString("onsaledate"));
            goodsoperater.setOnsaleprice(rs.getInt("onsaleprice"));
            goodsoperater.setState(rs.getInt("state"));
            list.add(goodsoperater);
        }
        return list;
    }
}
