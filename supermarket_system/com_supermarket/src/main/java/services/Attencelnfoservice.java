package services;

import Dao.AttencelnfoImpl;
import entity.Attencelnfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
public class Attencelnfoservice {
    AttencelnfoImpl attenceinfo = new AttencelnfoImpl();

    //查询收银员考勤情况
    public List<Attencelnfo> select_all(){
        String sql = "select * from Attencelnfo";
        List<Attencelnfo> list = attenceinfo.executeQuery(sql,null);
        return list;
    }

    //上班打卡
    public int onduty(int empno){
        int Flag = -1;
        String sql = "insert into Attencelnfo(attencelnfono,empno,onduty,ondutydate,outduty,outdutydate,date) values(?,?,?,?,?,?,?)";
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Object[] objects = new Object[]{null,empno,1,date,null,null,simpleDateFormat.format(date)};
        Flag = attenceinfo.executeUpdate(sql,objects);
        return Flag;
    }
    //下班打卡
    public int outdaty(int empno,String d){
        int Flag = -1;
        Date date = new Date();
        String sql = "update Attencelnfo set outduty=?,outdutydate=? where empno=? and date=?";
        Object[] objects = new Object[]{1,date,empno,d};
        return attenceinfo.executeUpdate(sql,objects);
    }



}
