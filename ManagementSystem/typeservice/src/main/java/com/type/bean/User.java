package com.type.bean;

//用户信息
public class User {
    //个人信息
    private String u_email;
    private String u_password;
    private int u_identity;   //
    private String u_name;//
    private int u_gender;
    private int u_age;
    private String c_no;
    private String employee_email;       //员工的email

    @Override
    public String toString() {
        return "User{" +
                "u_email='" + u_email + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_identity=" + u_identity +
                ", u_name='" + u_name + '\'' +
                ", u_gender=" + u_gender +
                ", u_age=" + u_age +
                ", c_no='" + c_no + '\'' +
                ", employee_email='" + employee_email + '\'' +
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

    public int getU_identity() {
        return u_identity;
    }

    public void setU_identity(int u_identity) {
        this.u_identity = u_identity;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public int getU_gender() {
        return u_gender;
    }

    public void setU_gender(int u_gender) {
        this.u_gender = u_gender;
    }

    public int getU_age() {
        return u_age;
    }

    public void setU_age(int u_age) {
        this.u_age = u_age;
    }

    public String getC_no() {
        return c_no;
    }

    public void setC_no(String c_no) {
        this.c_no = c_no;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }
}
