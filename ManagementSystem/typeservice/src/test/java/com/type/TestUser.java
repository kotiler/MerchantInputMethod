package com.type;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc

public class TestUser {
    @Autowired
    MockMvc mockMvc;

    @Test//用户更改账号密码失败测试
    public void changePassword_error() throws Exception{
        String user = "{\"u_email\":\"1233asf4@qq.com\",\"u_password\":\"123456\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/change").content(user).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("修改失败，邮箱不存在"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(4000));

    }

    @Test//用户更改账号密码成功测试
    public void changePassword_ok() throws Exception{
        String user = "{\"u_email\":\"1234@qq.com\",\"u_password\":\"123456789\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/change").content(user).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("修改密码成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(4004));
    }



    @Test//用户更改个人信息测试
    public void changeUserInfo_ok() throws Exception{
        String user = "{\"u_email\":\"12334@qq.com\"," +
                "\"u_password\":\"3456\",\"u_identity\":12,\"c_id\":\"123\",\"u_name\":\"123\",\"u_gender\":12,\"u_age\":12}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/changeUserInfo").content(user).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("修改个人中心信息成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(5001));

    }



    @Test//用户登录失败测试
    public void login_noEmailError() throws Exception{
        String user = "{\"u_email\":\"1212334@qq.com\",\"u_password\":\"1234\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/login").content(user).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("登录失败，邮箱不存在，请先注册"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(2001));
    }

    @Test//用户登录成功测试
    public void login_ok() throws Exception{
        String user = "{\"u_email\":\"12345@qq.com\",\"u_password\":\"12345\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/login").content(user).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("登录成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(2000));
    }
    @Test//用户个人信息展示测试
    public void showUserInfo() throws Exception{
        String user = "{\"u_email\":\"12345@qq.com\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/showUserInfo").content(user).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.u_email").value("12345@qq.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.u_password").value("12345"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.u_identity").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.c_no").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.u_name").value("dsa"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.u_gender").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.u_age").value(45));
    }
    @Test//用户注册失败测试
    public void register_error() throws Exception{
        String user = "{\"u_email\":\"12345@qq.com\",\"u_password\":\"123456789\",\"c_name\":\"深圳蜜汁有限公司\",\"c_address\":\"大同路\",\"c_type\":\"科技\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/register").content(user).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("注册失败，邮箱已存在"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(3001));
    }

    @Test//用户注册成功测试
    public void register_ok() throws Exception{
        String user = "{\"u_email\":\"12334@qq.com\"," +
                "\"u_password\":\"123\",\"c_name\":\"深圳蜜汁有限公司\",\"c_address\":\"大同路\",\"c_type\":\"科技\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/register").content(user).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("注册成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(3000));
    }

}