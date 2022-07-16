package com.type.dao;

import com.type.bean.Company;
import com.type.bean.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface CompanyDao {
    //检查邮箱个数接口
    public int checkEmailNum(@Param("u_email") String email);
    //展示公司接口
    public List<Company> showCompany(Company company);
    //添加公司接口
    public void addCompany(Company company);

    //注册公司接口
    public void register(Company company);
    //添加公司管理员接口
    public void addAdministrator(Company company);
    //查找公司品数量接口
    public int checkCompanyNum(Company company);
    //删除公司接口
    public void deleteCompany(Company company);
    //修改公司品信息接口
    public void modifyCompany(Company company);
    //搜索公司品接口
    public List<Company> searchCompany(Company company);
    //展示未审核公司接口
    public List<Company> showUncheckedCompany(Company company);
    //审核公司通过接口
    public void checkCompany(Company company);



}
