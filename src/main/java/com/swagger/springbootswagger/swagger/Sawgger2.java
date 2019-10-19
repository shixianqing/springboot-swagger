package com.swagger.springbootswagger.swagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
 * @Author:shixianqing
 * @Date:2018/9/1417:08
 * @Description:
 **/
@EnableSwagger2
//是否开启swagger页面增强
@EnableSwaggerBootstrapUI
@Configuration
//是否开启swagger
@ConditionalOnProperty(name = "spring.swagger2.enabled",havingValue = "true")
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
