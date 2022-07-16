package com.type.bean;

import java.util.Date;

//话术信息
public class Words {
    //话术信息
    //话术信息
    private String u_email;
    private int w_no;
    private String w_content;
    private String w_createDate;
    private int w_checkState;   //
    //如果是修改话术 操作那么需要多一个参数，不是修改操作就当作没有这个参数
    private String  new_w_content;        //新的话术内容

    private int g_no;

    @Override
    public String toString() {
        return "Words{" +
                "u_email='" + u_email + '\'' +
                ", w_no=" + w_no +
                ", w_content='" + w_content + '\'' +
                ", w_createDate='" + w_createDate + '\'' +
                ", w_checkState=" + w_checkState +
                ", new_w_content='" + new_w_content + '\'' +
                ", g_no=" + g_no +
                '}';
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }
    public int getW_no() {
        return w_no;
    }

    public void setW_no(int w_no) {
        this.w_no = w_no;
    }

    public String getW_content() {
        return w_content;
    }

    public void setW_content(String w_content) {
        this.w_content = w_content;
    }

    public String getW_createDate() {
        return w_createDate;
    }

    public void setW_createDate(String w_createDate) {
        this.w_createDate = w_createDate;
    }

    public int getW_checkState() {
        return w_checkState;
    }

    public void setW_checkState(int w_checkState) {
        this.w_checkState = w_checkState;
    }

    public String getNew_w_content() {
        return new_w_content;
    }

    public void setNew_w_content(String new_w_content) {
        this.new_w_content = new_w_content;
    }

    public int getG_no() {
        return g_no;
    }

    public void setG_no(int g_no) {
        this.g_no = g_no;
    }
}
