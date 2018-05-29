package entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/18.
 */
public class Employeelnfo  implements Serializable{
    private int empno;
    private String ename;
    private String sex;
    private String account;
    private String phone;
    private String password;
    private int isadmin;
    private int isenable;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(int isadmin) {
        this.isadmin = isadmin;
    }

    public int getIsenable() {
        return isenable;
    }

    public void setIsenable(int isenable) {
        this.isenable = isenable;
    }

    @Override
    public String toString() {
        return "Employeelnfo{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", sex='" + sex + '\'' +
                ", account='" + account + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", isadmin=" + isadmin +
                ", isenable=" + isenable +
                '}';
    }
}
