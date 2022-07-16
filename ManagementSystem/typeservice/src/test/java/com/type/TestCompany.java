package com.type;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc

public class TestCompany {
    @Autowired
    MockMvc mockMvc;

    @Test//后台管理员展示公司列表
    public void showCompany_ok() throws Exception{
        String company = "{\"u_email\":\"1234567@qq.com\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/company/showCompany").content(company).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
    @Test//删除公司测试
    public void deleteCompony_ok() throws Exception{
        String company = "{\"u_email\":\"1234567@qq.com\", \"c_name\":\"干净又卫生\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/company/deleteCompany").content(company).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("删除公司成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(8000));
    }
    @Test//搜索公司测试
    public void searchCompany() throws  Exception{
        String company = "{\"u_email\":\"1234567\",\"c_name\":\"梦\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/company/searchCompany").content(company).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

}
