package com.type.result;

import lombok.Data;

@Data//@Data 注解的主要作用是提高代码的简洁，使用这个注解可以省去代码中大量的get()、 set()、 toString()等方法；
public class ReturnResult_IdentifyCode{
    private String identifingCode;

    public static ReturnResult_IdentifyCode getIdentifingCode(String text){
        ReturnResult_IdentifyCode r=new ReturnResult_IdentifyCode();
        r.setIdentifingCode(text);
        return r;
    }


}



