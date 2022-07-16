package com.type.dao;

import com.type.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface WorkersDao {

    //检查邮箱个数接口
    public int checkEmailNum(@Param("u_email") String email);

    //展示员工接口
    public List<User> showWorkers(User user);
    //添加员工接口
    public void addWorkers(User user);
    //查找员工数量接口
    public int checkWorkersNum(User user);
    //删除员工接口
    public void deleteWorkers(User user);
    //修改员工信息接口
    public void modifyWorkers(User user);
    //搜索员工接口
    public List<User> searchWorkers(User user);

}
