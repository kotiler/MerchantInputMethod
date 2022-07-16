package com.type.dao;

import com.type.bean.Goods;
import com.type.bean.GoodsWords;
import com.type.bean.Words;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface GoodsWordsDao {
    //检查邮箱个数接口
    public int checkEmailNum(@Param("u_email") String email);
    //展示商品话术接口
    public List<GoodsWords> showGoodsWords(GoodsWords goodsWords);
    //查找商品话术数量接口
    public int checkGoodsWordsNum(GoodsWords goodsWords);
    //添加商品接口
    public void addGoodsWords(GoodsWords goodsWords);
    //删除商品接口
    public void deleteGoodsWords(GoodsWords goodsWords);

    //搜索商品话术接口
    public List<GoodsWords> searchGoodsWords(GoodsWords goodsWords);
}
