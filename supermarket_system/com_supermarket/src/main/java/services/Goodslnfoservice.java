package services;

import Dao.GoodslnfoImpl;
import entity.Goodslnfo;

import java.util.ArrayList;
import java.util.List;

import static UI.Admin_User.empno;

/**
 * Created by Administrator on 2018/4/19.
 */
public class Goodslnfoservice {
    GoodslnfoImpl goodslnfoimpl = new GoodslnfoImpl();

    //查询所有库存商品的详细信息
    public List<Goodslnfo> select_all() {
        String sql = "select * from Goodslnfo";
        List<Goodslnfo> list = goodslnfoimpl.executeQuery(sql, null);
        return list;
    }

    //根据商品的条码具体查询某一件商品的库存信息
    public Goodslnfo select_Goodsscode(String goodsscode) {
        String sql = "select * from Goodslnfo where goodsscode=? ";
        Object[] objects = new Object[]{goodsscode};
        List<Goodslnfo> list = goodslnfoimpl.executeQuery(sql, objects);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    //商品入库
    public int in_goodsinfo( String goodsscode,String goodsptype,String goodsuit, String goodsname, int goodsalarm,int goodsprice,int goodstock){
        int Flag = -1;
        String sql = "insert into Goodslnfo values(?,?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{goodsscode,empno,goodsptype,goodsuit,goodsname,goodsalarm,goodsprice,goodstock};
        Flag = goodslnfoimpl.executeUpdate(sql,objects);
        return Flag;
    }

    //修改库存商品信息
    public int updateBy_goodsscode(String goodsunit, String goodsname, String goodsscode) {
        int Flag = -1;
        String sql = "update Goodslnfo set goodsunit=?,goodsname=? where goodsscode=?";
        Object[] objects = new Object[]{};
        Flag = goodslnfoimpl.executeUpdate(sql, objects);
        return Flag;
    }

    //删除库存商品
    public int deleteBy_goodsscode(String goodsscode) {
        int Flag = -1;
       String sql = "delete from Goodslnfo where goodsscode=?";
       Object[] objects = new Object[]{goodsscode};
        Flag = goodslnfoimpl.executeUpdate(sql,objects);
        return Flag;
    }

    //上下架完成后，要更新库存表中的商品信息
    public int updatecount_Byupproduct(String goodsscode, int goodstock){
        int Flag = -1;
        String sql = "update Goodslnfo set goodstock=? where goodsscode=?";
        Object[] objects = new Object[]{goodstock,goodsscode};
        Flag = goodslnfoimpl.executeUpdate(sql,objects);
        return Flag;
    }

    //销售完成后，更新数据库商品数量
    public int updatecount_Bysales(String goodsscode, int goodstock) {
        int Flag = -1;
        String sql = "update Goodslnfo set goodstock=? where goodsscode=?";
        Object[] objects = new Object[]{goodstock,goodsscode};
        Flag = goodslnfoimpl.executeUpdate(sql, objects);
        return Flag;
    }

}
