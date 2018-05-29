package entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/18.
 */
public class Goodsoperater implements Serializable {
    private int goodsoperaterid;
    private int empno;
    private  String goodsscode;
    private String goodsname;
    private String onsaledate;
    private int onsaleprice;
    private int state;
    private int upcount;
    private int downcount;

    public int getGoodsoperaterid() {
        return goodsoperaterid;
    }

    public void setGoodsoperaterid(int goodsoperaterid) {
        this.goodsoperaterid = goodsoperaterid;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getGoodsscode() {
        return goodsscode;
    }

    public void setGoodsscode(String goodsscode) {
        this.goodsscode = goodsscode;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getOnsaledate() {
        return onsaledate;
    }

    public void setOnsaledate(String onsaledate) {
        this.onsaledate = onsaledate;
    }

    public int getOnsaleprice() {
        return onsaleprice;
    }

    public void setOnsaleprice(int onsaleprice) {
        this.onsaleprice = onsaleprice;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUpcount() {
        return upcount;
    }

    public void setUpcount(int upcount) {
        this.upcount = upcount;
    }

    public int getDowncount() {
        return downcount;
    }

    public void setDowncount(int downcount) {
        this.downcount = downcount;
    }

    @Override
    public String toString() {
        return "Goodsoperaterservice{" +
                "goodsoperaterid=" + goodsoperaterid +
                ", empno=" + empno +
                ", goodsscode='" + goodsscode + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", onsaledate='" + onsaledate + '\'' +
                ", onsaleprice=" + onsaleprice +
                ", state=" + state +
                ", upcount=" + upcount +
                ", downcount=" + downcount +
                '}';
    }
}
