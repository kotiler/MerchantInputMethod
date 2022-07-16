package com.type.dao;

import com.type.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository

public interface UserDao {
    //检查邮箱个数接口
    public int checkEmailNum(@Param("u_email") String email);
    //得到特指邮箱对应密码接口
    public String getuser_Password(@Param("u_email") String email);
    //检查登录身份接口
    public int getIdentity(@Param("u_email") String email);
    //添加用户接口
    public int addUser(User user);
    //修改密码接口
    public void change(User user);
    //修改个人信息接口
    public void changeUserInfo(User user);
    //展示个人信息接口
    public User showUserInfo(User user);



}
