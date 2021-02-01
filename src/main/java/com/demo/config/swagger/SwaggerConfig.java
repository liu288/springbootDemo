package com.demo.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("测试01")
                .apiInfo(new ApiInfoBuilder()
                        .title("接口信息文档")
                        .description("接口描述信息")
                        //new Contact()  第一个参数是创建者,第二个是连接地址(可以不配),第三个参数是邮箱(可以不配)
                        .contact(new Contact("pipixia", "", ""))
                        .version("版本号:1.0")
                        .build())
                .select()
                //扫描Api接口的包监听是哪一个路径的
                .apis(RequestHandlerSelectors.basePackage("com.demo.test.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
