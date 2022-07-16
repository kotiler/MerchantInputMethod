package com.type.service;

import com.type.bean.User;
import com.type.dao.WorkersDao;
import com.type.result.ResultCodeEnum;
import com.type.result.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Service
public class WorkersService {
    @Autowired//@RequestBody
    WorkersDao workersDao;
    //显示员工页面 的信息
    public List<User> ShowWorkers(User user){
        //邮箱存在，展示该公司的员工列表
        if(workersDao.checkEmailNum(user.getU_email())>0){
            System.out.println(workersDao.showWorkers(user) +"   zenml");
            System.out.println("nihao");
            return workersDao.showWorkers(user);
        }
        return null;
    }
    //处理添加员工请求
    public ReturnResult AddWorkers(User user){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.ADDWORKERS_SUCCESS);
        if(workersDao.checkWorkersNum(user)>0){       //员工存在
            result=ReturnResult.getState(ResultCodeEnum.ADDWORKERS_ERROR);
        }
        else{ //员工不存在
            result=ReturnResult.getState(ResultCodeEnum.ADDWORKERS_SUCCESS);
            workersDao.addWorkers(user);
        }
        return result;
    }
    //删除员工请求
    public ReturnResult DeleteWorkers(User user){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.DELETEWORKERS_ERROR);
        //System.out.println(user);
        if(workersDao.checkWorkersNum(user)>0){       //员工存在
            result=ReturnResult.getState(ResultCodeEnum.DELETEWORKERS_SUCCESS);
            workersDao.deleteWorkers(user);
        }
        else    //员工不存在
            result=ReturnResult.getState(ResultCodeEnum.DELETEWORKERS_ERROR);

        return result;
    }

    //
    public ReturnResult ModifyWorkers(User user){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.MODIFYGOODS_SUCCESS);
        //System.out.println(user);
        if(workersDao.checkWorkersNum(user)>0){//        商品存在
            result=ReturnResult.getState(ResultCodeEnum.MODIFYGOODS_SUCCESS);
            workersDao.modifyWorkers(user);
        }
        else    //商品不存在
            result=ReturnResult.getState(ResultCodeEnum.MODIFYGOODS_ERROR);
        return result;
    }

    public List<User> SearchWorkers(User user){//显示商品页面 的信息
        return workersDao.searchWorkers(user);
    }

    //审核商品通过

}
