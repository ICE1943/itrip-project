package com.itrip.auth.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ice
 */
@Configuration
@EnableSwagger2
@ComponentScan(value = {"com.itrip.auth.controller"})
public class SwaggerConfig {


    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select().apis(RequestHandlerSelectors.basePackage("com.itrip.auth.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("Swagger Auth 模块")
                .termsOfServiceUrl("localhost:8080")
                .description("Auth 接口")
                .build();
    }
}