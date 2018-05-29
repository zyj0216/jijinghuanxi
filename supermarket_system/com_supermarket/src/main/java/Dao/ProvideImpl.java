package Dao;

import entity.Provide;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */
public class ProvideImpl extends BaseDAO<Provide> {
    public List<Provide> rsToList(ResultSet rs) throws SQLException {
        List<Provide> list = new ArrayList<Provide>();
        while (rs.next()){
            Provide provide = new Provide();
            provide.setProvideid(rs.getInt("provideid"));
            provide.setProvidename(rs.getString("providename"));
            provide.setProvidemanager(rs.getString("providemanager"));
            provide.setProvidecontact(rs.getString("providecontact"));
            provide.setProvideaddress(rs.getString("provideaddress"));
            provide.setProvidephone(rs.getString("providephone"));
            list.add(provide);
        }
        return list;
    }
}
