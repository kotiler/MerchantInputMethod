package com.type.controller;
import com.type.bean.Goods;
import com.type.bean.Words;
import com.type.result.ReturnResult;
import com.type.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags="商品管理")

@CrossOrigin
@RestController//@RestController是@ResponseBody和@Controller的组合注解。
@RequestMapping("/goods")
public class GoodsController {
    @Autowired//@Autowired 注释，它可以对类成员变量、
    public GoodsService goodsService;

    @ApiOperation(value = "展示商品",notes = "登录后页面展示商品")
    @PostMapping("/showGoods")//登录后页面展示商品 post请求
    public List<Goods> ShowGoods(@RequestBody Goods goods){return goodsService.ShowGoods(goods);}

    @ApiOperation(value = "添加商品",notes = "添加商品")
    @PostMapping("/addGoods")//添加商品 post请求
    public ReturnResult AddGoods(@RequestBody Goods goods){ return goodsService.AddGoods(goods); }

    @ApiOperation(value = "删除商品",notes = "删除商品")
    @PostMapping("/deleteGoods")//删除商品 post请求
    public ReturnResult DeleteGoods(@RequestBody Goods goods){return goodsService.DeleteGoods(goods);}

    @ApiOperation(value = "删除商品",notes = "删除商品")
    @PostMapping("/modifyGoods")//处理修改商品 post请求
    public ReturnResult modifyGoods(@RequestBody Goods goods){ return goodsService.ModifyGoods(goods); }

    @ApiOperation(value = "搜索商品",notes = "搜索商品")
    @PostMapping("/searchGoods")//搜索商品 post请求
    public List<Goods> SearchGoods(@RequestBody Goods goods){return goodsService.SearchGoods(goods);}

    @ApiOperation(value = "展示未审核商品",notes = "展示未审核商品")
    @PostMapping("/showUncheckedGoods")//展示未审核商品 post请求
    public List<Goods> ShowUncheckedGoods(@RequestBody Goods goods){return goodsService.ShowUncheckedGoods(goods);}

    @ApiOperation(value = "商品审核",notes = "商品审核通过")
    @PostMapping("/checkGoods")//商品审核通过 post请求
    public ReturnResult checkGoods(@RequestBody Goods goods){ return goodsService.CheckGoods(goods); }




}
