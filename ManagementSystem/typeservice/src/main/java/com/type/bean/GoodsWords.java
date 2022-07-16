package com.type.bean;

//话术信息
public class GoodsWords {
    //话术信息
    private String u_email;
    private int w_no;
    private String w_content;
    private String  w_createDate;
    private String w_checkState;
    private String g_name;

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public void setW_no(int w_no) {
        this.w_no = w_no;
    }

    public void setW_content(String w_content) {
        this.w_content = w_content;
    }

    public void setW_createDate(String w_createDate) {
        this.w_createDate = w_createDate;
    }


    public int getW_no() {
        return w_no;
    }

    public String getW_content() {
        return w_content;
    }

    public String getW_createDate() {
        return w_createDate;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }
    public String getW_checkState() {
        return w_checkState;
    }

    public void setW_checkState(String w_checkState) {
        this.w_checkState = w_checkState;
    }
}
