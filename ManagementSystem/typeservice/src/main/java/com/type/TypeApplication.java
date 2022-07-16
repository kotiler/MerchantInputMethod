package com.type;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.type")//对包下所有的接口进行实现
@SpringBootApplication//@SpringBootApplication  : 是Sprnig Boot项目的核心注解，目的是开启自动配置
@EnableSwagger2
public class TypeApplication {
    public static void main(String[] args) {
        SpringApplication.run(TypeApplication.class, args);
    }

}
