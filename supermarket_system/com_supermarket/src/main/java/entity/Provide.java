package entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/18.
 */
public class Provide implements Serializable {
    private int provideid;
    private String providename;
    private String providemanager;
    private String providecontact;
    private String provideaddress;
    private String providephone;

    public int getProvideid() {
        return provideid;
    }

    public void setProvideid(int provideid) {
        this.provideid = provideid;
    }

    public String getProvidename() {
        return providename;
    }

    public void setProvidename(String providename) {
        this.providename = providename;
    }

    public String getProvidemanager() {
        return providemanager;
    }

    public void setProvidemanager(String providemanager) {
        this.providemanager = providemanager;
    }

    public String getProvidecontact() {
        return providecontact;
    }

    public void setProvidecontact(String providecontact) {
        this.providecontact = providecontact;
    }

    public String getProvideaddress() {
        return provideaddress;
    }

    public void setProvideaddress(String provideaddress) {
        this.provideaddress = provideaddress;
    }

    public String getProvidephone() {
        return providephone;
    }

    public void setProvidephone(String providephone) {
        this.providephone = providephone;
    }

    @Override
    public String toString() {
        return "Provide{" +
                "provideid=" + provideid +
                ", providename='" + providename + '\'' +
                ", providemanager='" + providemanager + '\'' +
                ", providecontact='" + providecontact + '\'' +
                ", provideaddress='" + provideaddress + '\'' +
                ", providephone='" + providephone + '\'' +
                '}';
    }
}
