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
public class TestUserWords {
    @Autowired
    MockMvc mockMvc;

    @Test//展示个人话术测试
    public void showUserWords_ok() throws Exception{
        String userwords = "{\"u_email\":\"1234567@qq.com\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/userwords/showUserWords").content(userwords).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
    @Test//添加个人话术成功测试
    public void addUserWords_ok() throws Exception{
        String userwords = "{\"u_email\":\"1234567@qq.com\",\"w_content\":\"这是我个人的话术哦\",\"w_createDate\":\"2022-4-9\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/userwords/addUserWords").content(userwords).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("添加话术成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(7000));
    }

    @Test//添加个人话术失败测试
    public void addUserWords_error() throws Exception{
        String userwords = "{\"u_email\":\"1234567@qq.com\",\"w_content\":\"亲，看看我们的新产品\",\"w_createDate\":\"2022-4-9\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/userwords/addUserWords").content(userwords).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("添加失败，话术已存在"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(7001));
    }

    @Test//删除个人话术失败测试
    public void deleteUserWords_error() throws Exception{
        String userwords = "{\"u_email\":\"123456789@qq.com\",\"w_content\":\"亲，亲爱的顾客，我们的产品矜持泰国原装进口，采用人体R2曲线设计，柔软细腻\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/userwords/deleteUserWords").content(userwords).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("删除话术失败，不存在这条话术"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(8002));
    }
    @Test//删除个人话术成功测试
    public void deleteUserWords_ok() throws Exception{
        String userwords = "{\"u_email\":\"123456789@qq.com\",\"w_content\":\"亲，早上好\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/userwords/deleteUserWords").content(userwords).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("删除话术成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(8000));
    }

    @Test//搜索个人话术测试
    public void searchUserWords() throws  Exception{
        String userwords = "{\"u_email\":\"1234567@qq.com\",\"w_content\":\"亲亲\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/userwords/searchUserWords").content(userwords).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}
