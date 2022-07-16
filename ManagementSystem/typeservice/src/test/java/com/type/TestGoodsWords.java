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
public class TestGoodsWords {
    @Autowired
    MockMvc mockMvc;

    @Test//展示商品话术测试
    public void showGoodsWords_ok() throws Exception{
        String goodswords = "{\"u_email\":\"1234567@qq.com\",\"g_name\":\"泰国乳胶枕进口天然乳胶枕\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goodswords/showGoodsWords").content(goodswords).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
    @Test//添加商品话术成功测试
    public void addGoodsWords_ok() throws Exception{
        String goodswords = "{\"u_email\":\"1234567@qq.com\", \"g_name\":\"泰国乳胶枕进口天然乳胶枕\",\"w_content\":\"亲，看看我们的新产品\",\"w_createDate\":\"2022-4-9\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goodswords/addGoodsWords").content(goodswords).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("添加商品话术成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(7000));
    }

    @Test//添加商品话术失败测试
    public void addGoodsWords_error() throws Exception{
        String goodswords = "{\"u_email\":\"1234567@qq.com\",\"g_name\":\"泰国乳胶枕进口天然乳胶枕\",\"w_content\":\"亲，看看我们的新产品\",\"w_createDate\":\"2022-4-9\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goodswords/addGoodsWords").content(goodswords).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("添加失败，话术已存在"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(7001));
    }

    @Test//删除商品话术失败测试
    public void deleteGoodsWords_error() throws Exception{
        String goodswords = "{\"u_email\":\"123456789@qq.com\",\"g_name\":\"泰国乳胶枕进口天然乳胶枕\",\"w_content\":\"亲，亲爱的顾客，我们的产品矜持泰国原装进口，采用人体R2曲线设计，柔软细腻\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goodswords/deleteGoodsWords").content(goodswords).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("删除商品话术失败，不存在这条商品话术"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(8002));
    }
    @Test//删除商品话术成功测试
    public void deleteGoodsWords_ok() throws Exception{
        String goodswords = "{\"u_email\":\"123456789@qq.com\",\"g_name\":\"被芯 星座恋人\",\"w_content\":\"感谢您选择七孔春秋被我们的产品，一床优质的加绒被芯，一个愉悦身心的梦境，一场无与伦比的睡眠体验。\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goodswords/deleteGoodsWords").content(goodswords).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("删除商品话术成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(8000));
    }

    @Test//搜索商品话术测试
    public void searchGoodsWords() throws  Exception{
        String goodswords = "{\"u_email\":\"1234567@qq.com\",\"w_content\":\"亲亲\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goodswords/searchGoodsWords").content(goodswords).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}

