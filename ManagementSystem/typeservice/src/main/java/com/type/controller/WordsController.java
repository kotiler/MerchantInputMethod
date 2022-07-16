package com.type.controller;
import com.type.bean.User;
import com.type.bean.Words;
import com.type.result.ReturnResult;
import com.type.service.WordsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "公司话术管理")
@CrossOrigin
@RestController//@RestController是@ResponseBody和@Controller的组合注解。
@RequestMapping("/words")
public class WordsController {
    @Autowired//@Autowired 注释，它可以对类成员变量、
    public WordsService wordsService;
    @ApiOperation(value = "展示话术", notes = "话术的展示")
    @PostMapping("/showWords")//登录后页面展示话术 post请求
    public List<Words> ShowWords(@RequestBody Words words){return wordsService.ShowWords(words);}

    @ApiOperation(value = "添加话术", notes = "话术的添加")
    @PostMapping("/addWords")//添加话术 post请求
    public ReturnResult AddWords(@RequestBody Words words){return wordsService.AddWords(words);}

    @ApiOperation(value = "删除话术", notes = "话术的删除")
    @PostMapping("/deleteWords")//删除话术 post请求
    public ReturnResult DeleteWords(@RequestBody Words words){return wordsService.DeleteWords(words);}

    @ApiOperation(value = "修改话术", notes = "话术的修改")
    @PostMapping("/modifyWords")//处理修改话术 post请求
    public ReturnResult modifyWords(@RequestBody Words words){System.out.println(words.toString());return wordsService.ModifyWords(words);}

    @ApiOperation(value = "搜索话术", notes = "话术的搜索")
    @PostMapping("/searchWords")//搜索话术 post请求
    public List<Words> SearchWords(@RequestBody Words words){return wordsService.SearchWords(words);}

    @ApiOperation(value = "展示未审核话术", notes = "负责未审核话术的展示，方便审核")
    @PostMapping("/showUncheckedWords")//展示未审核话术 post请求
    public List<Words> ShowUncheckedWords(@RequestBody Words words){return wordsService.ShowUncheckedWords(words);}

    @ApiOperation(value = "审核话术", notes = "话术审核通过")
    @PostMapping("/checkWords")//审核话术通过 post请求
    public ReturnResult CheckWords(@RequestBody Words words){System.out.println(words.toString());return wordsService.CheckWords(words);}




}
