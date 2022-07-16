package com.type.controller;

import com.type.bean.Goods;
import com.type.bean.GoodsWords;
import com.type.bean.Words;
import com.type.result.ReturnResult;
import com.type.service.GoodsService;
import com.type.service.GoodsWordsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags="商品话术管理")

@CrossOrigin
@RestController//@RestController是@ResponseBody和@Controller的组合注解。
@RequestMapping("/goodswords")
public class GoodsWordsController {
    @Autowired//@Autowired 注释，它可以对类成员变量、
    public GoodsWordsService goodsWordsService;

    @ApiOperation(value = "展示商品话术",notes = "登录后页面展示商品话术")
    @PostMapping("/showGoodsWords")//点击商品 后展示商品话术的 post请求
    public List<GoodsWords> ShowGoodsWords(@RequestBody GoodsWords goodsWords){return goodsWordsService.ShowGoodsWords(goodsWords);}

    @ApiOperation(value = "添加商品话术",notes = "添加商品话术")
    @PostMapping("/addGoodsWords")//添加商品话术 post请求
    public ReturnResult AddGoodsWords(@RequestBody GoodsWords goodsWords){ return goodsWordsService.AddGoodsWords(goodsWords); }

    @ApiOperation(value = "删除商品话术",notes = "删除商品话术")
    @PostMapping("/deleteGoodsWords")//删除商品话术 post请求
    public ReturnResult DeleteGoodsWords(@RequestBody GoodsWords goodsWords){return goodsWordsService.DeleteGoodsWords(goodsWords);}

    @ApiOperation(value = "搜索商品话术",notes = "搜索商品话术")
    @PostMapping("/searchGoodsWords")//搜索商品话术 post请求
    public List<GoodsWords> SearchWords(@RequestBody GoodsWords goodsWords){return goodsWordsService.SearchGoodsWords(goodsWords);}
}
