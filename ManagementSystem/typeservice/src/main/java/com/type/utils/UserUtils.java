package com.type.utils;



//用户相关的一些函数集合，比如检验邮箱合法性
public class UserUtils {
    private static final int maxEmailLength=30;
    private static final int maxUsernameLength=20;
    private static final int maxPasswordLength=15;
    //返回0代表邮箱合法，非0代表不合法，这样设计是因为不合法有很多种情况：邮箱太长，不是邮箱等等，
    //这样设计为后续扩展流伏笔
    public static int isEmailValid(String email){
        if(email.length()>maxEmailLength){
            return 0;
        }
        return 1;
    }
    public static int isUsernameValid(String username){
        if(username.length()>maxUsernameLength){
            return 0;
        }
        return 1;
    }
    public static int isPasswordValid(String password){
        if(password.length()>maxPasswordLength){
            return 0;
        }
        return 1;
    }
}
