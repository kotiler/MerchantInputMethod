package com.type.service;
import com.type.bean.Goods;
import com.type.bean.User;
import com.type.bean.Words;
import com.type.dao.GoodsDao;
import com.type.result.ResultCodeEnum;
import com.type.result.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@Service
public class GoodsService {
    @Autowired//@RequestBody
    GoodsDao goodsDao;
    //显示商品页面 的信息
    public List<Goods> ShowGoods(Goods goods){
        //邮箱存在，展示对应的个人信息
        if(goodsDao.checkEmailNum(goods.getU_email())>0){
            System.out.println(goodsDao.showGoods(goods));

            return goodsDao.showGoods(goods);
        }
        return null;
    }
    //处理添加商品请求
    public ReturnResult AddGoods(Goods goods){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.ADDGOODS_SUCCESS);
        if(goodsDao.checkGoodsNum(goods)>0){       //商品存在
            result=ReturnResult.getState(ResultCodeEnum.ADDGOODS_ERROR);
        }
        else{ //商品不存在
            result=ReturnResult.getState(ResultCodeEnum.ADDGOODS_SUCCESS);
            goodsDao.addGoods(goods);
        }
        return result;
    }
    //删除商品请求
    public ReturnResult DeleteGoods(Goods goods){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.DELETEGOODS_ERROR);
        if(goodsDao.checkGoodsNum(goods)>0){       //商品存在
            result=ReturnResult.getState(ResultCodeEnum.DELETEGOODS_SUCCESS);
            goodsDao.deleteGoods(goods);
        }
        else    //商品不存在
            result=ReturnResult.getState(ResultCodeEnum.DELETEGOODS_ERROR);

        return result;
    }

    //处理修改商品信息请求
    public ReturnResult ModifyGoods(Goods goods){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.MODIFYGOODS_SUCCESS);
        //System.out.println(goods);
        if(goodsDao.checkGoodsNum(goods)>0){//        商品存在
            result=ReturnResult.getState(ResultCodeEnum.MODIFYGOODS_SUCCESS);
            goodsDao.modifyGoods(goods);
        }
        else    //商品不存在
            result=ReturnResult.getState(ResultCodeEnum.MODIFYGOODS_ERROR);
        return result;
    }

    public List<Goods> SearchGoods(Goods goods){//显示商品页面 的信息
        return goodsDao.searchGoods(goods);
    }

    //显示未审核商品页面的信息
    public List<Goods> ShowUncheckedGoods(Goods goods){
        //邮箱存在，展示对应的个人信息
        if(goodsDao.checkEmailNum(goods.getU_email())>0){
            System.out.println(goodsDao.showUncheckedGoods(goods));
            return goodsDao.showUncheckedGoods(goods);
        }
        return null;
    }

    //处理审核商品通过请求 在未审核商品时只有通过和不通过两个选择 此处是通过审核 不通过则直接删除
    public ReturnResult CheckGoods(Goods goods){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.CHECKGOODS_SUCCESS);
        //System.out.println(goods);
        goodsDao.checkGoods(goods);

        return result;
    }
}
