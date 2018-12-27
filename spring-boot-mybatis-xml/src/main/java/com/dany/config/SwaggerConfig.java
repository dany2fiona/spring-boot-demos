package com.dany.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket swaggerSpringMvcPlugin(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())////api的标题、描述、版本等信息
                .groupName("spring-boot-swagger")////接口模块名称
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())//路径判断
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("dan.y RESTful API")
                .description("spring-boot swagger")
                .termsOfServiceUrl("http://localhost:8080/")////（不可见）条款地址
                .contact(new Contact("dan.y","https://blog.csdn.net/HiBoyljw/article/details/81110553","yangdan90@126.com"))
                .description("此API提供接口调用")
//                .license("License Version 1.0")
                .version("1.0").build();
    }

}
