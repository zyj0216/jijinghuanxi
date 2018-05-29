package entity;

import javax.naming.directory.SearchResult;
import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/18.
 */
public class Purchase implements Serializable {
    private int purchaseid;
    private String goodsscode;
    private String goodsname;
    private String purchasetime;
    private int purchasecount;
    private int purchaseprice;
    private String provideid;

    public int getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(int purchaseid) {
        this.purchaseid = purchaseid;
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

    public String getPurchasetime() {
        return purchasetime;
    }

    public void setPurchasetime(String purchasetime) {
        this.purchasetime = purchasetime;
    }

    public int getPurchasecount() {
        return purchasecount;
    }

    public void setPurchasecount(int purchasecount) {
        this.purchasecount = purchasecount;
    }

    public int getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(int purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public String getProvideid() {
        return provideid;
    }

    public void setProvideid(String provideid) {
        this.provideid = provideid;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseid=" + purchaseid +
                ", goodscode='" + goodsscode + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", purchasetime='" + purchasetime + '\'' +
                ", purchasecount=" + purchasecount +
                ", purchaseprice=" + purchaseprice +
                ", provideid='" + provideid + '\'' +
                '}';
    }
}
