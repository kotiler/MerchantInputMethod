package com.type.service;
import com.type.bean.User;
import com.type.bean.Words;
import com.type.dao.WordsDao;
import com.type.result.ResultCodeEnum;
import com.type.result.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@Service
public class WordsService {
    @Autowired//@RequestBody
    WordsDao wordsDao;
    public List<Words> ShowWords(Words words){//显示话术页面 的信息
        if(wordsDao.checkEmailNum(words.getU_email())>0){//邮箱存在
            System.out.println(wordsDao.showWords(words));
            return wordsDao.showWords(words);
        }
        return null;
    }

    public ReturnResult AddWords(Words words){        //处理添加话术请求
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.ADDWORDS_SUCCESS);
        if(wordsDao.checkWordsNum(words)>0){       //话术存在
            result=ReturnResult.getState(ResultCodeEnum.ADDWORDS_ERROR);
        }
        else{
            result=ReturnResult.getState(ResultCodeEnum.ADDWORDS_SUCCESS);
            wordsDao.addWords(words);
        }
        return result;
    }

    public ReturnResult DeleteWords(Words words){        //删除话术请求
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.DELETEWORDS_ERROR);
        //System.out.println(words);
        if(wordsDao.checkWordsNum(words)>0){       //话术存在
            result=ReturnResult.getState(ResultCodeEnum.DELETEWORDS_SUCCESS);
            wordsDao.deleteWords(words);
        }
        else
            result=ReturnResult.getState(ResultCodeEnum.DELETEWORDS_ERROR);

        return result;
    }


    public ReturnResult ModifyWords(Words words){//处理修改话术信息请求
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.MODIFYWORDS_SUCCESS);
        //System.out.println(words);
        if(wordsDao.checkWordsNum(words)>0){//        话术存在
            result=ReturnResult.getState(ResultCodeEnum.MODIFYWORDS_SUCCESS);
            wordsDao.modifyWords(words);
        }
        else
            result=ReturnResult.getState(ResultCodeEnum.MODIFYWORDS_ERROR);
        return result;
    }


    public List<Words> SearchWords(Words words){//搜索后的话术 的信息
        return wordsDao.searchWords(words);
    }


    //展示未审核话术的的信息
    public List<Words> ShowUncheckedWords(Words words){//显示话术页面 的信息
        if(wordsDao.checkEmailNum(words.getU_email())>0){//邮箱存在
            System.out.println(wordsDao.showUncheckedWords(words));
            return wordsDao.showUncheckedWords(words);
        }
        return null;
    }

    //处理审核话术通过请求 在未审核话术时只有通过和不通过两个选择 此处是通过审核 不通过则直接删除
    public ReturnResult CheckWords(Words words){//处理修改话术信息请求
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.CHECKWORDS_SUCCESS);
        wordsDao.checkWords(words);
        return result;
    }

}
