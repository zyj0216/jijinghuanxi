package com.zhang.service;

import com.zhang.DAO.DomitoryImpl;
import com.zhang.entity.Domitory;

import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */
public class DomitoryService {
    DomitoryImpl domitoryImpl=new DomitoryImpl();

    /**
     * 查询所有楼宇
     */
    public List<Domitory> selectAll(){
        String sql = "select * from domitory";
        Object[] objects = null;
        return domitoryImpl.executeQuery(sql,objects);
    }

    /**
     * 添加宿舍
     */
    public int addDomitory(Domitory domitory){
        String sql = "insert into domitory values(?,?,?,?,?)";
        Object[] objects = new Object[]{
                domitory.getBuilding_id(),
                domitory.getDomitory_number(),
                domitory.getDomitory_type(),
                domitory.getDomitory_tel(),
                domitory.getDomitory_person()
        };
        return domitoryImpl.executeUpdate(sql,objects);
    }

    /**
     * 删除宿舍
     */
    public int delete(int building_id,int domitory_number){
        String sql = "delete from domitory where building_id=? and domitory_number=?";
        Object[] objects = new Object[]{building_id,domitory_number};
        return domitoryImpl.executeUpdate(sql,objects);
    }

    /**
     * 修改宿舍信息
     */
    public int updata(Domitory domitory){
        String sql = "update domitory set domitory_type=?,domitory_tel=?,domitory_person=? where building_id=? and domitory_number=?";
        Object[] objects = new Object[]{
                domitory.getDomitory_type(),
                domitory.getDomitory_tel(),
                domitory.getDomitory_person(),
                domitory.getBuilding_id(),
                domitory.getDomitory_number()
        };
        return domitoryImpl.executeUpdate(sql,objects);
    }

    /**
     * 根据building_id和domitory_number查找宿舍
     * //先查找未迁入时的宿舍现有人数
     */
    public Domitory selectBy(int building_id,int domitory_number){
        String sql = "select * from domitory where building_id=? and domitory_number=?";
        Object[] objects = new Object[]{building_id,domitory_number};
        List<Domitory> list = domitoryImpl.executeQuery(sql,objects);
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    /**
     * 做学生迁入，迁入学生时，迁入的宿舍人数+1
     */
    //将现有的宿舍人数+1
    public int updatePersonadd(int domitory_number, int person){
        String sql = "update domitory set domitory_person=? where domitory_number=?";
        Object[] objects=new Object[]{person+1,domitory_number};
        return domitoryImpl.executeUpdate(sql,objects);
    }

    //将现有的宿舍人数-1
    public int updatePersonMinus(int domitory_number, int person){
        String sql = "update domitory set domitory_person=? where domitory_number=?";
        Object[] objects=new Object[]{person-1,domitory_number};
        return domitoryImpl.executeUpdate(sql,objects);
    }
}
