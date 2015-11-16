package com.gorulia.android.runcrmrun.pojo;

import java.util.Date;

public class ObjectItem {

    private String title;
    private String subTitle;
    private Date date;
    private String icon;
    private int x1, x2;

    public ObjectItem(String title, String subTitle, Date date, int x1, int x2, String icon) {
        this.title = title;
        this.subTitle = subTitle;
        this.date = date;
        this.x1 = x1;
        this.x2 = x2;
        this.icon = icon;
    }
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String image) {
        this.icon = image;
    }
}