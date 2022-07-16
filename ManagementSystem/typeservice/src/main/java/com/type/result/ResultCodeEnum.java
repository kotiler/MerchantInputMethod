package com.type.result;

import lombok.Getter;


@Getter//@Getter ：可以为相应的属性自动生成Getter方法
public enum ResultCodeEnum {
    LOGIN_OK1(true,2000,"登录成功"),
    LOGIN_OK2(true,2004,"登录成功"),
    LOGIN_EMAIL_ERROR(false,2001,"登录失败，邮箱不存在，请先注册"),
    LOGIN_PASSWORD_ERROR(false,2002,"登录失败，密码错误"),

    REGISTER_SUCCESS(true,3000,"注册成功"),
    REGISTER_EMAIL_ERROR(false,3001,"注册失败，邮箱已存在"),

    CHANGE_EMAIL_ERROR(false,4000,"修改失败，邮箱不存在"),
    CHANGE_OK(true,4004,"修改密码成功"),

    SAVE_OK(true,5000,"保存成功"),

    CHANGE_USERINFO_OK(true,5001,"修改个人中心信息成功"),

    SHOW_USERINFO_OK(true,6001,"查询个人中心信息成功"),



    ADDWORDS_SUCCESS(true,7000,"添加话术成功"),
    ADDWORDS_ERROR(false,7001,"添加失败，话术已存在"),

    DELETEWORDS_SUCCESS(true,8000,"删除话术成功"),
    DELETEWORDS_ERROR(false,8002,"删除话术失败，不存在这条话术"),

    MODIFYWORDS_SUCCESS(true,5001,"修改话术成功"),
    MODIFYWORDS_ERROR(false,5002,"修改话术失败，不存在这条话术"),


    ADDGOODS_SUCCESS(true,7007,"添加商品成功"),
    ADDGOODS_ERROR(false,7008,"添加失败，商品已存在"),

    DELETEGOODS_SUCCESS(true,8000,"删除商品成功"),
    DELETEGOODS_ERROR(false,8002,"删除商品失败，不存在这个商品"),

    MODIFYGOODS_SUCCESS(true,9001,"修改商品成功"),
    MODIFYGOODS_ERROR(false,9002,"修改商品失败，不存在这个商品"),


    ADDWORKERS_SUCCESS(true,7007,"添加员工成功"),
    ADDWORKERS_ERROR(false,7008,"添加失败，员工已存在"),

    DELETEWORKERS_SUCCESS(true,8000,"删除员工成功"),
    DELETEWORKERS_ERROR(false,8002,"删除员工失败，不存在这名员工"),

    CHECKWORDS_SUCCESS(true,5001,"该话术审核通过"),
    CHECKGOODS_SUCCESS(true,5001,"该商品审核通过"),



    ADDCOMPANY_SUCCESS(true,7007,"添加公司成功"),
    ADDCOMPANY_ERROR(false,7008,"添加失败，公司已存在"),

    DELETECOMPANY_SUCCESS(true,8000,"删除公司成功"),
    DELETECOMPANY_ERROR(false,8002,"删除公司失败，不存在这个公司"),



    ADDGOODSWORDS_SUCCESS(true,7000,"添加商品话术成功"),
    ADDGOODSWORDS_ERROR(false,7001,"添加失败，商品话术已存在"),

    DELETEGOODSWORDS_SUCCESS(true,8000,"删除商品话术成功"),
    DELETEGOODSWORDS_ERROR(false,8002,"删除商品话术失败，不存在这条商品话术"),
    ;

    private Boolean status;
    private Integer code;
    private String message;



    ResultCodeEnum(Boolean status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
