package com.type.bean;

public class Company {
    private String u_email;
    private String u_password;
    private int c_no;
    private String c_name;
    private String c_type;
    private String c_connect;
    private String c_address;
    private String c_code;

    @Override
    public String toString() {
        return "Company{" +
                "c_no=" + c_no +
                ", c_name='" + c_name + '\'' +
                ", c_type='" + c_type + '\'' +
                ", c_connect='" + c_connect + '\'' +
                ", c_address='" + c_address + '\'' +
                ", c_code='" + c_code + '\'' +
                '}';
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public int getC_no() {
        return c_no;
    }

    public void setC_no(int c_no) {
        this.c_no = c_no;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_type() {
        return c_type;
    }

    public void setC_type(String c_type) {
        this.c_type = c_type;
    }

    public String getC_connect() {
        return c_connect;
    }

    public void setC_connect(String c_connect) {
        this.c_connect = c_connect;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }
}
