package com.type.controller;

import com.type.bean.Company;
import com.type.bean.User;
import com.type.result.ReturnResult;
import com.type.result.ReturnResult_IdentifyCode;
import com.type.service.CompanyService;
import com.type.service.EmailService;
import com.type.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理")
@CrossOrigin
@RestController//@RestController是@ResponseBody和@Controller的组合注解。
@RequestMapping("/user")
public class UserController {
    @Autowired//@Autowired 注释，它可以对类成员变量、
    public UserService service;

    @ApiOperation(value = "注册", notes = "公司注册")
    @PostMapping("/register")//注册 post请求
    public ReturnResult register(@RequestBody Company company){ return service.Register(company); }

    @ApiOperation(value = "登录", notes = "账号登录")
    @PostMapping("/login")//处理登录post请求
    public ReturnResult login(@RequestBody User user){return service.Login(user);}

    @ApiOperation(value = "修改密码", notes = "用户修改密码")
    @PostMapping("/change")//处理修改密码post请求
    public ReturnResult change(@RequestBody User user){return service.Change(user);}

    @ApiOperation(value = "修改个人信息", notes = "用户修改个人信息")
    @PostMapping("/changeUserInfo")//处理修改个人信息 post请求
    public ReturnResult changeUserInfo(@RequestBody User user){System.out.println(user.toString());return service.ChangeUserInfo(user);}

    @ApiOperation(value = "展示个人信息", notes = "用户展示个人信息")
    @PostMapping("/showUserInfo")//展示个人信息 post请求
    public User ShowUserInfo(@RequestBody User user){return service.ShowUserInfo(user);}

    @Autowired
    EmailService emailService;
    @ApiOperation(value = "发送验证码", notes = "在注册、修改密码时发送验证码")
    @PostMapping("/send")//处理发送验证码post请求
    public ReturnResult_IdentifyCode sendEmail(@RequestBody User user) throws JSONException {return service.sendVerificationCode(user);}

}
