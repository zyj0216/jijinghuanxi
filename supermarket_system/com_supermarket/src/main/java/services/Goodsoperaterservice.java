package services;

import Dao.GoodslnfoImpl;
import Dao.GoodsoperaterImpl;
import entity.Goodsoperater;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static UI.Admin_User.empno;

/**
 * Created by Administrator on 2018/4/21.
 */
public class Goodsoperaterservice {
    GoodsoperaterImpl goodsoperater = new GoodsoperaterImpl();


    /**
     * 上架商品
     *
     * @return
     */
    public int up_product(String goodsscode,String goodsname, int onsaleprice,int upcount){
        int Falg = -1;
        String sql = "insert into Goodsoperater values(?,?,?,?,?,?,?,?,?)";
        Date date = new Date();
        Object[] objects = new Object[]{null,empno,goodsscode,goodsname,date,onsaleprice,1,upcount,null};
        Falg = goodsoperater.executeUpdate(sql,objects);
        return Falg;
    }

    //下架商品
    public int down_product(String goodsscode,String goodsname, int onsaleprice,int downcount){
        int Falg = -1;
        String sql = "insert into Goodsoperater values(?,?,?,?,?,?,?,?,?)";
        Date date = new Date();
        Object[] objects = new Object[]{null,empno,goodsscode,goodsname,date,onsaleprice,0,null,downcount};
        Falg = goodsoperater.executeUpdate(sql,objects);
        return Falg;
    }


    ///查询所有记录（上下架记录）
    public List<Goodsoperater> select_all() {
        String sql = "select * from Goodsoperater";
        List<Goodsoperater> list = goodsoperater.executeQuery(sql, null);
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
