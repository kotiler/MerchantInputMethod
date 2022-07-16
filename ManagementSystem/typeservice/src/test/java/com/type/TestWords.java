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

public class TestWords {
    @Autowired
    MockMvc mockMvc;

    @Test//添加话术成功测试
    public void addWords_ok() throws Exception{
        String words = "{\"email\":\"1234@qq.com\", \"w_content\":\"亲，看看我们的新产品\",\"w_createDate\":\"2022-4-9\",\"w_checkState\":\"0\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/words/addWords").content(words).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("添加话术成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(7000));
    }

    @Test//添加话术失败测试
    public void addWords_error() throws Exception{
        String words = "{\"email\":\"1234@qq.com\",\"w_content\":\"亲，看看我们的新产品\",\"w_createDate\":\"2022-4-9\",\"w_checkState\":\"0\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/words/addWords").content(words).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("添加失败，话术已存在"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(7001));
    }


    @Test//展示话术测试
    public void showWords_error() throws Exception{
        String words = "{\"email\":\"1234@qq.com\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/words/showWords").content(words).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test//修改话术成功测试
    public void modifyWords_ok() throws Exception{
        String words = "{\"email\":\"1234@qq.com\",\"w_content\":\"亲，看看我们的新产品\",\"w_checkState\":\"0\", \"new_w_content\":\"亲，看看我们的新产品\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/words/modifyWords").content(words).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("修改话术成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(5001));
    }

    @Test//修改话术失败测试
    public void modifyWords_error() throws Exception{
        String words = "{\"email\":\"1234@qq.com\",\"w_content\":\"亲，看看我们的哈哈哈\",\"w_checkState\":\"0\", \"new_w_content\":\"亲，看看我们的新产品\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/words/modifyWords").content(words).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("修改话术失败，不存在这条话术"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(5002));
    }

    @Test//删除话术成功测试
    public void deleteWords_ok() throws Exception{
        String words = "{\"email\":\"1234@qq.com\",\"w_content\":\"亲，看看我们的新产品\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/words/deleteWords").content(words).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("删除话术成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(8000));
    }

    @Test//展示未审核话术测试
    public void showUncheckedWords_error() throws Exception{
        String words = "{\"email\":\"1234@qq.com\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/words/showUncheckedWords").content(words).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test//审核话术通过测试
    public void checkWords_ok() throws Exception{
        String words = "{\"email\":\"1234@qq.com\",\"w_content\":\"亲，看看我们的新产品\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/words/modifyWords").content(words).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("该话术审核通过"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(5001));
    }
    @Test//搜索话术测试
    public void searchWords() throws  Exception{
        String words = "{\"u_email\":\"1234567\",\"w_content\":\"亲亲\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/words/searchWords").content(words).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

}
