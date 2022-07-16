package com.type.controller;
import com.type.bean.Company;
import com.type.result.ReturnResult;
import com.type.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(tags="公司管理")
@CrossOrigin
@RestController//@RestController是@ResponseBody和@Controller的组合注解。
@RequestMapping("/company")
public class CompanyController {
    @Autowired//@Autowired 注释，它可以对类成员变量、
    public CompanyService companyService;
    @ApiOperation(value = "展示公司",notes = "登录后页面展示公司")
    @PostMapping("/showCompany")//登录后页面展示公司 post请求
    public List<Company> Company(@RequestBody Company company){return companyService.ShowCompany(company);}

    /*@ApiOperation(value = "展示公司",notes = "登录后页面展示公司")
    @PostMapping("/addCompany")//注册 post请求
    public ReturnResult addCompany(@RequestBody Company company){ return companyService.addCompany(company); }*/

    @ApiOperation(value = "删除公司",notes = "公司的删除")
    @PostMapping("/deleteCompany")//删除公司 post请求
    public ReturnResult DeleteCompany(@RequestBody Company company){return companyService.DeleteCompany(company);}

    @ApiOperation(value = "搜索公司",notes = "公司的搜索")
    @PostMapping("/searchCompany")//搜索公司 post请求
    public List<Company> SearchCompany(@RequestBody Company company){return companyService.SearchCompany(company);}
//
//    @PostMapping("/showUncheckedCompany")//展示未审核公司 post请求
//    public List<Company> ShowUncheckedCompany(@RequestBody Company company){return companyService.ShowUncheckedCompany(company);}
//
//    @PostMapping("/checkCompany")//公司审核通过 post请求
//    public ReturnResult checkCompany(@RequestBody Company company){ return companyService.CheckCompany(company); }
}
