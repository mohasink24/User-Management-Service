package com.izak.project.users.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger configurations
 *
 * @author Mohasin Kazi
 * @since 1st March 2020
 */
@Configuration
@PropertySource({"classpath:swagger.properties", "classpath:application.properties"})
public class SwaggerConfiguration {

    @Autowired
    private Environment env;

    @Value("${swagger.enable:false}")
    private Boolean isEnabled;

    @Bean
    public Docket swaggerBean() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(isEnabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.izak.project.users.api.v1"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                .tags(new Tag(env.getProperty("swagger.display.project.name"), env.getProperty("swagger.display.project.description")));
    }


    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title(env.getProperty("swagger.display.page.title"))
                .description(env.getProperty("swagger.display.module.description"))
                .version(env.getProperty("swagger.display.version"))
                .build();
    }

}
