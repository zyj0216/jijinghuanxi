package com.zhang.DAO;

import com.zhang.entity.Change;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/17.
 */
public class ChangeImpl extends BaseDAO<Change> {
    @Override
    public List<Change> rsToList(ResultSet rs) throws SQLException {
        List<Change> list = new ArrayList<Change>();
        while (rs.next()){
            Change change = new Change();
            change.setChange_id(rs.getInt("change_id"));
            change.setStudent_id(rs.getInt("student_id"));
            change.setChange_date(rs.getString("change_date"));
            change.setAdmin_id(rs.getInt("admin_id"));
            change.setBeforebuilding_id(rs.getInt("beforebuilding_id"));
            change.setBeforedomotory_number(rs.getInt("beforedomotory_number"));
            change.setAfterbuilding_id(rs.getInt("afterbuilding_id"));
            change.setAfterdomitory_number(rs.getInt("afterdomitory_number"));
            list.add(change);
        }
        return list;
    }
}
