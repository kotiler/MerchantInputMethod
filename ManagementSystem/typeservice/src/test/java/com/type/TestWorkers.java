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

public class TestWorkers {
    @Autowired
    MockMvc mockMvc;

    @Test//获取员工列表测试
    public void showWorkers_ok() throws Exception{
        String workers = "{\"email\":\"1234@qq.com\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/workers/showWorkers").content(workers).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test//添加员工成功测试
    public void addWords_ok() throws Exception{
        String workers = "{\"email\":\"1234@qq.com\",\"employee_email\":\"111@qq.com\",\"username\":\"employee\",\"age\":\"19\", \"gender\":\"1\", \"identity\":\"3\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/workers/addWorkers").content(workers).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("添加员工成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(7007));
    }

    @Test//添加员工失败测试
    public void addWords_error() throws Exception{
        String workers = "{\"email\":\"1234@qq.com\",\"employee_email\":\"111@qq.com\",\"username\":\"employee\",\"age\":\"19\", \"gender\":\"1\", \"identity\":\"3\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/workers/addWorkers").content(workers).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("添加失败，员工已存在"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(7008));
    }

    @Test//删除员工成功测试
    public void deleteWords_ok() throws Exception{
        String workers = "{\"email\":\"1234@qq.com\",\"employee_email\":\"111@qq.com\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/workers//deleteWorkers").content(workers).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("删除员工成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(8000));
    }

    @Test//删除员工失败测试
    public void deleteWords_error() throws Exception{
        String workers = "{\"email\":\"1234@qq.com\",\"employee_email\":\"222@qq.com\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/workers//deleteWorkers").content(workers).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("删除员工失败，不存在这名员工"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(8002));
    }

    @Test//搜索员工测试
    public void searchWorkers_ok() throws Exception{
        String workers = "{\"email\":\"1234@qq.com\",\"username\":\"employee\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/workers/searchWorkers").content(workers).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}
