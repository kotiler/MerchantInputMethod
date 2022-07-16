package com.type.service;

import com.type.bean.Company;
import com.type.dao.CompanyDao;
import com.type.result.ResultCodeEnum;
import com.type.result.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Service
public class CompanyService {
    @Autowired//@RequestBody
    CompanyDao companyDao;
    //显示公司页面 的信息
    public List<Company> ShowCompany(Company company){
        if(companyDao.checkEmailNum(company.getU_email())>0)    //邮箱账号属于系统管理员
            return companyDao.showCompany(company);
        return null;
    }



    //处理添加公司请求
    public ReturnResult addCompany(Company company){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.ADDCOMPANY_SUCCESS);
        if(companyDao.checkCompanyNum(company)>0){       //公司存在
            result=ReturnResult.getState(ResultCodeEnum.ADDCOMPANY_ERROR);
        }
        else{ //公司不存在
            result=ReturnResult.getState(ResultCodeEnum.ADDCOMPANY_SUCCESS);
            companyDao.addCompany(company);
            companyDao.addAdministrator(company);
        }
        return result;
    }

    //删除公司请求
    public ReturnResult DeleteCompany(Company company){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.DELETECOMPANY_ERROR);
        if(companyDao.checkEmailNum(company.getU_email())>0&&companyDao.checkCompanyNum(company)>0){       //邮箱账号属于系统管理员且该公司存在
            result=ReturnResult.getState(ResultCodeEnum.DELETECOMPANY_SUCCESS);
            companyDao.deleteCompany(company);
        }
        else    //公司不存在
            result=ReturnResult.getState(ResultCodeEnum.DELETECOMPANY_ERROR);

        return result;
    }

    //处理修改公司信息请求
    public ReturnResult ModifyCompany(Company company){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.MODIFYGOODS_SUCCESS);
        if(companyDao.checkCompanyNum(company)>0){//        公司存在
            result=ReturnResult.getState(ResultCodeEnum.MODIFYGOODS_SUCCESS);
            companyDao.modifyCompany(company);
        }
        else    //公司不存在
            result=ReturnResult.getState(ResultCodeEnum.MODIFYGOODS_ERROR);
        return result;
    }

    public List<Company> SearchCompany(Company company){//搜搜公司页面 的信息
        if(companyDao.checkEmailNum(company.getU_email())>0){       //邮箱账号属于系统管理员
            return companyDao.searchCompany(company);
        }
        return null;
    }

    //显示未审核公司页面的信息
    public List<Company> ShowUncheckedCompany(Company company){
        //邮箱存在，展示对应的个人信息
        if(companyDao.checkEmailNum(company.getC_name())>0){
            System.out.println(companyDao.showUncheckedCompany(company));
            return companyDao.showUncheckedCompany(company);
        }
        return null;
    }

    //处理审核公司通过请求 在未审核公司品时只有通过和不通过两个选择 此处是通过审核 不通过则直接删除
    public ReturnResult CheckCompany(Company company){
        ReturnResult result=ReturnResult.getState(ResultCodeEnum.CHECKGOODS_SUCCESS);
        companyDao.checkCompany(company);

        return result;
    }
}
