package com.example.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration implements WebFluxConfigurer {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.poc"))
                .paths(PathSelectors.any())
                .build().apiInfo(metadata());
    }

    private ApiInfo metadata(){
        return new ApiInfoBuilder()
                .title("Crud Operations - Reactive Programming Using Spring Webflux")
                .description("APIs for performing basic crud operations")
                .version("1.0.0")
                .build();
    }

}
