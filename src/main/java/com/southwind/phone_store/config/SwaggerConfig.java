package com.southwind.phone_store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//  配置Swagger的Docket的Bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }


//  配置swagger信息=apiInfo
    private ApiInfo apiInfo(){
//      作者信息
        Contact contact = new Contact("evan","http://www.evan.com","evan@gmail.com");
         return new ApiInfo(
                 "手机商城API文档",
                 "请仔细阅读",
                 "v1.0",
                 "evan@gmail.com",
                 contact,
                 "Apache2.0",
                 "Apache.com",
                 new ArrayList<>()

         );


    }


}
