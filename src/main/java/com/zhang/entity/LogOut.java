package com.zhang.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/17.
 */
public class LogOut implements Serializable {
    private int logout_id;
    private int student_id;
    private String student_name;
    private String student_class;
    private String log_date;
    private String out_date;
    private String log_remark;
    private int admin_id;
    private int LogOut_type;

    public int getLogout_id() {
        return logout_id;
    }

    public void setLogout_id(int logout_id) {
        this.logout_id = logout_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getLog_date() {
        return log_date;
    }

    public void setLog_date(String log_date) {
        this.log_date = log_date;
    }

    public String getOut_date() {
        return out_date;
    }

    public void setOut_date(String out_date) {
        this.out_date = out_date;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getLog_remark() {
        return log_remark;
    }

    public void setLog_remark(String log_remark) {
        this.log_remark = log_remark;
    }

    public int getLogOut_type() {
        return LogOut_type;
    }

    public void setLogOut_type(int logOut_type) {
        LogOut_type = logOut_type;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    @Override
    public String toString() {
        return "LogOut{" +
                "logout_id=" + logout_id +
                ", student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_class='" + student_class + '\'' +
                ", log_date='" + log_date + '\'' +
                ", out_date='" + out_date + '\'' +
                ", admin_id=" + admin_id +
                ", log_remark='" + log_remark + '\'' +
                ", LogOut_type=" + LogOut_type +
                '}';
    }
}
