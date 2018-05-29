package entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/18.
 */
public class Attencelnfo implements Serializable{
    private int attencelnfono;
    private int empno;
    private int onduty;
    private String ondutydate;
    private int outduty;
    private  String outdutydate;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAttencelnfono() {
        return attencelnfono;
    }

    public void setAttencelnfono(int attencelnfono) {
        this.attencelnfono = attencelnfono;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public int getOnduty() {
        return onduty;
    }

    public void setOnduty(int onduty) {
        this.onduty = onduty;
    }

    public String getOndutydate() {
        return ondutydate;
    }

    public void setOndutydate(String ondutydate) {
        this.ondutydate = ondutydate;
    }

    public int getOutduty() {
        return outduty;
    }

    public void setOutduty(int outduty) {
        this.outduty = outduty;
    }

    public String getOutdutydate() {
        return outdutydate;
    }

    public void setOutdutydate(String outdutydate) {
        this.outdutydate = outdutydate;
    }

    @Override
    public String toString() {
        return "Attencelnfo{" +
                "attencelnfono=" + attencelnfono +
                ", empno=" + empno +
                ", onduty=" + onduty +
                ", ondutydate='" + ondutydate + '\'' +
                ", outduty=" + outduty +
                ", outdutydate='" + outdutydate + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
