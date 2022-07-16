package com.type.bean;

import java.util.Date;

//话术信息
public class UserWords {


    //话术信息
    private String u_email;
    private int w_no;
    private String w_content;
    private String  w_createDate;

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
}
