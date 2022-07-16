package com.type.result;

import lombok.Getter;


@Getter//@Getter ：可以为相应的属性自动生成Getter方法
public enum ResultIdentifyCode {;
    private String identifingCode;

    ResultIdentifyCode(String identifingCode) {
        this.identifingCode=identifingCode;
    }
}
