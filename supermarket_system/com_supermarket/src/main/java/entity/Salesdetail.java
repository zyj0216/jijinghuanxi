package entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/18.
 */
public class Salesdetail implements Serializable{
    private int detailid;
    private int empno;
    private String goodsscode;
    private String goodsname;
    private int count;
    private int unitprice;
    private int sumprice;
    private String saledate;

    public int getDetailid() {
        return detailid;
    }

    public void setDetailid(int detailid) {
        this.detailid = detailid;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getGoodscode() {
        return goodsscode;
    }

    public void setGoodscode(String goodscode) {
        this.goodsscode = goodscode;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(int unitprice) {
        this.unitprice = unitprice;
    }

    public int getSumprice() {
        return sumprice;
    }

    public void setSumprice(int sumprice) {
        this.sumprice = sumprice;
    }

    public String getSaledate() {
        return saledate;
    }

    public void setSaledate(String saledate) {
        this.saledate = saledate;
    }

    @Override
    public String toString() {
        return "Salesdetail{" +
                "detailid=" + detailid +
                ", empno=" + empno +
                ", goodscode='" + goodsscode + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", count=" + count +
                ", unitprice=" + unitprice +
                ", sumprice=" + sumprice +
                ", saledate='" + saledate + '\'' +
                '}';
    }
}
