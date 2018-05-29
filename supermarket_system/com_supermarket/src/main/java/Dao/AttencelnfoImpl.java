package Dao;

import entity.Attencelnfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */
public class AttencelnfoImpl extends BaseDAO<Attencelnfo> {
    public List<Attencelnfo> rsToList(ResultSet rs) throws SQLException {
        List<Attencelnfo> list = new ArrayList<Attencelnfo>();
        while(rs.next()){
            Attencelnfo attenceinfo = new Attencelnfo();
            attenceinfo.setAttencelnfono(rs.getInt("attencelnfono"));
            attenceinfo.setEmpno(rs.getInt("empno"));
            attenceinfo.setOnduty(rs.getInt("onduty"));
            attenceinfo.setOndutydate(rs.getString("ondutydate"));
            attenceinfo.setOutduty(rs.getInt("outduty"));
            attenceinfo.setOndutydate(rs.getString("outdutydate"));
            attenceinfo.setDate(rs.getString("date"));
            list.add(attenceinfo);
        }
        return list;
    }
}
