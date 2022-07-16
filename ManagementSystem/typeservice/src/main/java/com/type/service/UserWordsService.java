package com.type.service;

import com.type.bean.User;
import com.type.bean.UserWords;
import com.type.dao.UserWordsDao;
import com.type.result.ResultCodeEnum;
import com.type.result.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Service
public class UserWordsService {
    @Autowired//@RequestBody
    UserWordsDao userwordsDao;
    public List<UserWords> ShowUserWords(UserWords userWords){//显示话术页面 的信息
        if(userwordsDao.checkEmailNum(userWords.getU_email())>0){//邮箱存在
            System.out.println(userwordsDao.showUserWords(userWords));
            return userwordsDao.showUserWords(userWords);
        }
        return null;
    }

    public ReturnResult AddUserWords(UserWords userWords){        //处理添加话术请求
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.ADDWORDS_SUCCESS);
        if(userwordsDao.checkUserWordsNum(userWords)>0){       //话术存在
            result=ReturnResult.getState(ResultCodeEnum.ADDWORDS_ERROR);
        }
        else{
            result=ReturnResult.getState(ResultCodeEnum.ADDWORDS_SUCCESS);
            userwordsDao.addUserWords(userWords);
        }
        return result;
    }

    public ReturnResult DeleteUserWords(UserWords userWords){        //删除话术请求
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.DELETEWORDS_ERROR);
        //System.out.println(user);
        if(userwordsDao.checkUserWordsNum(userWords)>0){       //话术存在
            result=ReturnResult.getState(ResultCodeEnum.DELETEWORDS_SUCCESS);
            userwordsDao.deleteUserWords(userWords);
        }
        else
            result=ReturnResult.getState(ResultCodeEnum.DELETEWORDS_ERROR);

        return result;
    }

    public List<UserWords> SearchUserWords(UserWords userWords){//搜索后的话术 的信息
        return userwordsDao.searchUserWords(userWords);
    }

}
