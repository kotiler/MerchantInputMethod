package com.type.configuration;


import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger使用的配置文件
 */
@Configuration
//@Configuration用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，
// 这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，
// 并用于构建bean定义，初始化Spring容器。
@EnableSwagger2
public class Swagger2Configuration {
    @Bean//配置了swagger的Docket的bean实例
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //RequestHandlerSelectors，配置要扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.type"))
                .build();
    }
    //配置swagger信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商家输入法API接口文档")
                .description("商家输入法：一个专门给商家使用的输入法，在基本的手机系统输入法的功能上，结合系统进销存系统数据，包含话术、商品等")
                .termsOfServiceUrl("http://localhost:8088/swagger-ui.html")
                .version("4.0")
                .build();
    }
}