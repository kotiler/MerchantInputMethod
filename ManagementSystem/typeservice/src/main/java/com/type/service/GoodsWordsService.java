package com.type.service;

import com.type.bean.Goods;
import com.type.bean.GoodsWords;
import com.type.bean.Words;
import com.type.dao.GoodsDao;
import com.type.dao.GoodsWordsDao;
import com.type.result.ResultCodeEnum;
import com.type.result.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Service
public class GoodsWordsService {
    @Autowired//@RequestBody
    GoodsWordsDao goodsWordsDao;

    //点击商品 后展示商品话术的 信息
    public List<GoodsWords> ShowGoodsWords(GoodsWords goodsWords){
        //邮箱存在，展示对应的商品话术信息
        if(goodsWordsDao.checkEmailNum(goodsWords.getU_email())>0){
            return goodsWordsDao.showGoodsWords(goodsWords);
        }
        return null;
    }

    //处理添加商品话术请求
    public ReturnResult AddGoodsWords(GoodsWords goodsWords){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.ADDGOODSWORDS_SUCCESS);
        if(goodsWordsDao.checkGoodsWordsNum(goodsWords)>0){       //商品话术存在
            result=ReturnResult.getState(ResultCodeEnum.ADDGOODSWORDS_ERROR);
        }
        else{ //商品话术不存在
            result=ReturnResult.getState(ResultCodeEnum.ADDGOODSWORDS_SUCCESS);
            goodsWordsDao.addGoodsWords(goodsWords);
        }
        return result;
    }

    //删除商品请求
    public ReturnResult DeleteGoodsWords(GoodsWords goodsWords){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.DELETEGOODSWORDS_ERROR);
        if(goodsWordsDao.checkGoodsWordsNum(goodsWords)>0){       //商品话术存在
            result=ReturnResult.getState(ResultCodeEnum.DELETEGOODSWORDS_SUCCESS);
            goodsWordsDao.deleteGoodsWords(goodsWords);
        }
        else    //商品话术不存在
            result=ReturnResult.getState(ResultCodeEnum.DELETEGOODSWORDS_ERROR);

        return result;
    }

    public List<GoodsWords> SearchGoodsWords(GoodsWords goodsWords){//搜索后的话术 的信息
        //System.out.println(goodsWordsDao.searchGoodsWords(goodsWords));
        return goodsWordsDao.searchGoodsWords(goodsWords);
    }


}
