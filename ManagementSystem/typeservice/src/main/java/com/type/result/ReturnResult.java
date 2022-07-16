package com.type.result;

import lombok.Data;

@Data//@Data 注解的主要作用是提高代码的简洁，使用这个注解可以省去代码中大量的get()、 set()、 toString()等方法；
public class ReturnResult{
    private Boolean success;
    private Integer code;
    private String message;

    //private Map<String,Object> data=new HashMap<>();
    public static ReturnResult getState(ResultCodeEnum re){
        ReturnResult r=new ReturnResult();
        r.setSuccess(re.getStatus());
        r.setCode(re.getCode());
        r.setMessage(re.getMessage());
        return r;
    }
}


