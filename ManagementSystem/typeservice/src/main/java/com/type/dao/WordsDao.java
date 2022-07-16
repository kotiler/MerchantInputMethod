package com.type.dao;

import com.type.bean.User;
import com.type.bean.Words;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface WordsDao {
    //检查邮箱个数接口
    public int checkEmailNum(@Param("u_email") String email);
    //展示话术接口
    public List<Words> showWords(Words words);
    //添加话术接口
    public void addWords(Words words);
    //查找话术个数接口
    public int checkWordsNum(Words words);
    //删除话术接口
    public void deleteWords(Words words);
    //修改话术接口
    public void modifyWords(Words words);
    //搜素话术接口
    public List<Words> searchWords(Words words);
    //展示未审核话术接口
    public List<Words> showUncheckedWords(Words words);
    //审核商品通过接口
    public void checkWords(Words words);
}
