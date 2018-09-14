package com.swagger.springbootswagger.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author:shixianqing
 * @Date:2018/9/1417:08
 * @Description:
 **/
@Configuration
public class Sawgger2 {

    @Bean
    public Docket createRestApi(){

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).
                select().apis(RequestHandlerSelectors.basePackage("com.swagger.springbootswagger.controller"))
                .paths(PathSelectors.any()).build();
    }

    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Spring boot中使用Swagger2构建RESTful APIs").version("1.0").build();
    }
}
