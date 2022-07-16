package com.type.controller;
import com.type.bean.User;
import com.type.bean.UserWords;
import com.type.result.ReturnResult;
import com.type.service.UserWordsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "个人话术管理")
@CrossOrigin
@RestController//@RestController是@ResponseBody和@Controller的组合注解。
@RequestMapping("/userwords")
public class UserWordsController {
    @Autowired//@Autowired 注释，它可以对类成员变量、
    public UserWordsService userwordsService;
    @ApiOperation(value = "展示个人话术", notes = "个人话术的展示")
    @PostMapping("/showUserWords")//登录后页面展示话术 post请求
    public List<UserWords> ShowUserWords(@RequestBody UserWords userwords){return userwordsService.ShowUserWords(userwords);}

    @ApiOperation(value = "添加个人话术", notes = "个人话术的添加")
    @PostMapping("/addUserWords")//添加话术 post请求
    public ReturnResult AddUserWords(@RequestBody UserWords userwords){return userwordsService.AddUserWords(userwords);}

    @ApiOperation(value = "删除个人话术", notes = "个人话术的删除")
    @PostMapping("/deleteUserWords")//删除话术 post请求
    public ReturnResult DeleteUserWords(@RequestBody UserWords userwords){return userwordsService.DeleteUserWords(userwords);}

    @ApiOperation(value = "搜索个人话术", notes = "个人话术的搜索")
    @PostMapping("/searchUserWords")//搜索话术 post请求
    public List<UserWords> SearchUserWords(@RequestBody UserWords userwords){return userwordsService.SearchUserWords(userwords);}

}
