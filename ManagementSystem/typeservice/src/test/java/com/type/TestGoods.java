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

public class TestGoods {
    @Autowired
    MockMvc mockMvc;

    @Test//添加商品成功测试
    public void addGoods_ok() throws Exception{
        String goods = "{\"email\":\"1234@qq.com\", \"g_picture\":\"iVBORw0KGgoAAAANSUhEawfawfawefsdfasgafgsgsfasdfasf\",\"g_price\":\"444\",\"g_description\":\"恶心\", \"g_name\":\"难吃的东西\", \"g_addDate\":\"2021-03-01\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goods/addGoods").content(goods).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("添加商品成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(7007));
    }

    @Test//添加商品失败测试
    public void addGoods_error() throws Exception{
        String goods = "{\"email\":\"1234@qq.com\", \"g_picture\":\"iVBORw0KGgoAAAANSUhEawfawfawefsdfasgafgsgsfasdfasf\",\"g_price\":\"444\",\"g_description\":\"恶心\", \"g_name\":\"难吃的东西\", \"g_addDate\":\"2021-03-01\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goods/addGoods").content(goods).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("添加失败，商品已存在"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(7008));
    }


    @Test//展示商品测试
    public void showGoods() throws Exception{
        String goods = "{\"email\":\"1234@qq.com\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goods/showGoods").content(goods).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test//修改商品成功测试
    public void modifyGoods_ok() throws Exception{
        String goods = "{\"email\":\"1234@qq.com\", \"g_picture\":\"iVBORw0KGgoAAAANSUhEawfawfawefsdfasgafgsgsfasdfasf\",\"g_price\":\"555\",\"g_description\":\"好吃的\", \"g_name\":\"好吃的东西\", \"g_addDate\":\"2021-03-01\", \"new_g_name\":\"好吃的东西\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goods/modifyGoods").content(goods).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("修改商品成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(9001));
    }

    @Test//修改商品失败测试
    public void modifyGoods_error() throws Exception{
        String goods = "{\"email\":\"1234@qq.com\", \"g_picture\":\"iVBORw0KGgoAAAANSUhEawfawfawefsdfasgafgsgsfasdfasf\",\"g_price\":\"555\",\"g_description\":\"不存在的\", \"g_name\":\"不存在的东西\", \"g_addDate\":\"2021-03-01\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goods/modifyGoods").content(goods).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("修改商品失败，不存在这个商品"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(9002));
    }

    @Test//删除商品成功测试
    public void deleteGoods_ok() throws Exception{
        String goods = "{\"email\":\"1234@qq.com\", \"g_picture\":\"iVBORw0KGgoAAAANSUhEawfawfawefsdfasgafgsgsfasdfasf\",\"g_price\":\"555\",\"g_description\":\"恶心的\", \"g_name\":\"难吃的东西\", \"g_addDate\":\"2021-03-01\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goods/deleteGoods").content(goods).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("删除商品成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(8000));
    }

    @Test//删除商品失败测试
    public void deleteGoods_error() throws Exception{
        String goods = "{\"email\":\"1234@qq.com\", \"g_picture\":\"iVBORw0KGgoAAAANSUhEawfawfawefsdfasgafgsgsfasdfasf\",\"g_price\":\"555\",\"g_description\":\"不好吃的\", \"g_name\":\"不好吃的东西\", \"g_addDate\":\"2021-03-01\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goods/deleteGoods").content(goods).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("删除商品失败，不存在这个商品"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(8002));
    }

    @Test//展示未审核商品测试
    public void showUncheckedGoods() throws Exception{
        String goods = "{\"email\":\"1234@qq.com\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goods/showUncheckedGoods").content(goods).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test//审核商品通过测试
    public void checkGoods_ok() throws Exception{
        String goods = "{\"email\":\"1234@qq.com\", \"g_name\":\"好吃的东西\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goods/modifyGoods").content(goods).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("该商品审核通过"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(5001));
    }
    @Test//搜索商品测试
    public void searchGoods() throws  Exception{
        String goods = "{\"u_email\":\"1234567\",\"g_name\":\"睡眠\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goods/searchGoods").content(goods).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

}
