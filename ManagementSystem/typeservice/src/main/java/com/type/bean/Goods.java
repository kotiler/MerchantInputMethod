package com.type.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Goods {
    //商品信息
    private String u_email;
    private int g_no;
    private String g_picture;
    private float g_price;
    private String g_description;   //
    private String g_name;   //
    private String g_addDate;
    private int g_checkState;
    //如果是修改商品 操作那么需要多一个参数，不是修改操作就当作没有这个参数
    private String  new_g_name;        //新的商品名字
    //搜索需要用到的，最低价格和最高价格
    private int min_price;
    private int max_price;


    @Override
    public String toString() {
        return "Goods{" +
                "u_email='" + u_email + '\'' +
                ", g_no=" + g_no +
                ", g_picture='" + g_picture + '\'' +
                ", g_price=" + g_price +
                ", g_description='" + g_description + '\'' +
                ", g_name='" + g_name + '\'' +
                ", g_addDate='" + g_addDate + '\'' +
                ", g_checkState=" + g_checkState +
                ", new_g_name='" + new_g_name + '\'' +
                ", min_price=" + min_price +
                ", max_price=" + max_price +
                '}';
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public int getG_no() {
        return g_no;
    }

    public void setG_no(int g_no) {
        this.g_no = g_no;
    }

    public String getG_picture() {
        return g_picture;
    }

    public void setG_picture(String g_picture) {
        this.g_picture = g_picture;
    }

    public float getG_price() {
        return g_price;
    }

    public void setG_price(float g_price) {
        this.g_price = g_price;
    }

    public String getG_description() {
        return g_description;
    }

    public void setG_description(String g_description) {
        this.g_description = g_description;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getG_addDate() {
        return g_addDate;
    }

    public void setG_addDate(String g_addDate) {
        this.g_addDate = g_addDate;
    }

    public int getG_checkState() {
        return g_checkState;
    }

    public void setG_checkState(int g_checkState) {
        this.g_checkState = g_checkState;
    }

    public String getNew_g_name() {
        return new_g_name;
    }

    public void setNew_g_name(String new_g_name) {
        this.new_g_name = new_g_name;
    }

    public int getMin_price() {
        return min_price;
    }

    public void setMin_price(int min_price) {
        this.min_price = min_price;
    }

    public int getMax_price() {
        return max_price;
    }

    public void setMax_price(int max_price) {
        this.max_price = max_price;
    }
}
