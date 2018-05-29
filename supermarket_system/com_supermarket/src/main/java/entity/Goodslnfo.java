package entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/18.
 */
public class Goodslnfo implements Serializable {
    private String goodsscode;
    private int empno;
    private String goodstyle;
    private String goodsunit;
    private String goodsname;
    private int goodsalarm;
    private int goodsprice;
    private int goodstock;

    public String getGoodsscode() {
        return goodsscode;
    }

    public void setGoodsscode(String goodsscode) {
        this.goodsscode = goodsscode;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getGoodstyle() {
        return goodstyle;
    }

    public void setGoodstyle(String goodstyle) {
        this.goodstyle = goodstyle;
    }

    public String getGoodsunit() {
        return goodsunit;
    }

    public void setGoodsunit(String goodsunit) {
        this.goodsunit = goodsunit;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getGoodsalarm() {
        return goodsalarm;
    }

    public void setGoodsalarm(int goodsalarm) {
        this.goodsalarm = goodsalarm;
    }

    public int getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(int goodsprice) {
        this.goodsprice = goodsprice;
    }

    public int getGoodstock() {
        return goodstock;
    }

    public void setGoodstock(int goodstock) {
        this.goodstock = goodstock;
    }

    @Override
    public String toString() {
        return "Goodslnfo{" +
                "goodsscode='" + goodsscode + '\'' +
                ", empno=" + empno +
                ", goodstyle='" + goodstyle + '\'' +
                ", goodsunit='" + goodsunit + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", goodsalarm=" + goodsalarm +
                ", goodsprice=" + goodsprice +
                ", goodstock=" + goodstock +
                '}';
    }
}
