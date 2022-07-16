package com.type.service;
import com.type.bean.Company;
import com.type.bean.User;
import com.type.dao.CompanyDao;
import com.type.dao.UserDao;
import com.type.result.ResultCodeEnum;
import com.type.result.ReturnResult;
import com.type.result.ReturnResult_IdentifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@ResponseBody
@Service
public class UserService {
    @Autowired//@RequestBody
    UserDao userDao;
    @Autowired//@RequestBody
    CompanyDao companyDao;

    //处理注册请求
    public ReturnResult Register(Company company){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.REGISTER_SUCCESS);
        if(companyDao.checkCompanyNum(company)>0){       //公司存在
            result=ReturnResult.getState(ResultCodeEnum.REGISTER_EMAIL_ERROR);
        }
        else{ //公司不存在
            result=ReturnResult.getState(ResultCodeEnum.REGISTER_SUCCESS);
            companyDao.register(company);
            companyDao.addAdministrator(company);
        }
        return result;
    }

    public ReturnResult Login(User user){//处理登录请求
        ReturnResult result;
        //检测邮箱，密码完整性
        if(userDao.checkEmailNum(user.getU_email())>0){
            //邮箱存在
            if(userDao.getuser_Password(user.getU_email()).equals(user.getU_password()))
            {
                //密码正确
                if(userDao.getIdentity(user.getU_email()) == 1)
                    result=ReturnResult.getState(ResultCodeEnum.LOGIN_OK1);
                else
                    result = ReturnResult.getState(ResultCodeEnum.LOGIN_OK2);
            }
            else{
                //密码错误
                result=ReturnResult.getState(ResultCodeEnum.LOGIN_PASSWORD_ERROR);
            }
        }
        else{
            //邮箱错误
            result=ReturnResult.getState(ResultCodeEnum.LOGIN_EMAIL_ERROR);
        }
        return result;
    }

    public ReturnResult Change(User user){//处理修改密码请求
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.CHANGE_OK);
        //System.out.println(user);
        if(userDao.checkEmailNum(user.getU_email())>0){//邮箱存在
            result=ReturnResult.getState(ResultCodeEnum.CHANGE_OK);
            userDao.change(user);
        }
        else{
            result=ReturnResult.getState(ResultCodeEnum.CHANGE_EMAIL_ERROR);
        }
        return result;
    }

    public ReturnResult ChangeUserInfo(User user){//处理修改个人中心信息请求
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.CHANGE_USERINFO_OK);
        //System.out.println(user);
        if(userDao.checkEmailNum(user.getU_email())>0){//邮箱存在
            result=ReturnResult.getState(ResultCodeEnum.CHANGE_USERINFO_OK);
            userDao.changeUserInfo(user);
        }
        else{
            result=ReturnResult.getState(ResultCodeEnum.CHANGE_EMAIL_ERROR);
        }
        return result;
    }


    public User ShowUserInfo(User user){//显示个人中心信息
        if(userDao.checkEmailNum(user.getU_email())>0){//邮箱存在
            //System.out.println(userDao.showUserInfo(user));


            /*//将list<User>转为User数组
            User[] array =new User[userDao.showUserInfo(user).size()];
            userDao.showUserInfo(user).toArray(array);

            //逐个输出个人信息
            System.out.println("email："+array[0].getAge());
            System.out.println("username："+array[0].getUsername());
            System.out.println("gender："+array[0].getGender());
            System.out.println("identity："+array[0].getIdentity());
            System.out.println("c_id："+array[0].getC_id());
            System.out.println("password："+array[0].getPassword());*/
            return userDao.showUserInfo(user);
        }
        return null;
    }

    @Autowired
    EmailService emailService;
    public ReturnResult_IdentifyCode sendVerificationCode(User user){//处理发送验证码请求

        String to = user.getU_email();
        String subject = "商家输入法验证码";
        String str="0123456789";
        Random random=new Random();
        StringBuffer text=new StringBuffer();
        for(int i=0;i<6;i++){
            int number=random.nextInt(9);
            text.append(str.charAt(number));
        }
        emailService.sendEmail(to,subject,text.toString());
        System.out.println(text.toString());

        ReturnResult_IdentifyCode result=ReturnResult_IdentifyCode.getIdentifingCode(text.toString());

        return result;

    }


}
