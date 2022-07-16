package com.type.dao;

import com.type.bean.Goods;
import com.type.bean.User;
import com.type.bean.Words;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface GoodsDao {
    //检查邮箱个数接口
    public int checkEmailNum(@Param("u_email") String email);
    //展示商品接口
    public List<Goods> showGoods(Goods goods);
    //添加商品接口
    public void addGoods(Goods goods);
    //查找商品数量接口
    public int checkGoodsNum(Goods goods);
    //删除商品接口
    public void deleteGoods(Goods goods);
    //修改商品信息接口
    public void modifyGoods(Goods goods);
    //搜索商品接口
    public List<Goods> searchGoods(Goods goods);
    //展示未审核商品接口
    public List<Goods> showUncheckedGoods(Goods goods);
    //审核商品通过接口
    public void checkGoods(Goods goods);


    //查找商品话术数量接口
    public int checkGoodsWordsNum(Goods goods);
    //展示商品话术接口
    public List<Words> showGoodsWords(Goods goods);
    //添加商品接口
    public void addGoodsWords(Goods goods);
    //删除商品接口
    public void deleteGoodsWords(Goods goods);
}
