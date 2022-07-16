package com.type.dao;

import com.type.bean.User;
import com.type.bean.UserWords;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface UserWordsDao {
    //检查邮箱个数接口
    public int checkEmailNum(@Param("u_email") String email);
    //展示话术接口
    public List<UserWords> showUserWords(UserWords userWords);
    //添加话术接口
    public void addUserWords(UserWords userWords);
    //查找话术个数接口
    public int checkUserWordsNum(UserWords userWords);
    //删除话术接口
    public void deleteUserWords(UserWords userWords);
    //搜素话术接口
    public List<UserWords> searchUserWords(UserWords userWords);
}
