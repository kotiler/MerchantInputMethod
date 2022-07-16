package com.type.controller;

import com.type.bean.User;
import com.type.result.ReturnResult;

import com.type.service.WorkersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "员工管理")
@CrossOrigin
@RestController//@RestController是@ResponseBody和@Controller的组合注解。
@RequestMapping("/workers")
public class WorkersController {
    @Autowired//@Autowired 注释，它可以对类成员变量、
    public WorkersService workersService;
    @ApiOperation(value = "展示员工", notes = "员工的展示")
    @PostMapping("/showWorkers")//展示员工 post请求
    public List<User> ShowGoods(@RequestBody User user){return workersService.ShowWorkers(user);}

    @ApiOperation(value = "添加员工", notes = "员工的添加")
    @PostMapping("/addWorkers")//添加员工 post请求
    public ReturnResult AddGoods(@RequestBody User user){ return workersService.AddWorkers(user); }

    @ApiOperation(value = "删除员工", notes = "员工的删除")
    @PostMapping("/deleteWorkers")//删除员工 post请求
    public ReturnResult DeleteWorkers(@RequestBody User user){return workersService.DeleteWorkers(user);}

    @ApiOperation(value = "搜索员工", notes = "员工的搜索")
    @PostMapping("/searchWorkers")//搜索员工 post请求
    public List<User> SearchWorkers(@RequestBody User user){return workersService.SearchWorkers(user);}
}
