package br.com.fiap.helpers.config;


import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class SwaggerConfigBase {
    public static final String PACKAGE_BASE = "br.com.fiap.helpers";

    public SwaggerConfigBase() {
    }

    private ApiInfo apiInfo() {
        return (new ApiInfoBuilder()).title(this.getInfoTitle()).description(this.getDescriptionAPI()).termsOfServiceUrl("http://www.apache.org/licenses/LICENSE-2.0").contact(new Contact("Brasilprev", "", "")).license("JApache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").version("V1.0.0").build();
    }

    protected abstract String getDescriptionAPI();

    protected abstract String getInfoTitle();

    @Bean
    public Docket api() {
        return (new Docket(DocumentationType.SWAGGER_2)).select().apis(RequestHandlerSelectors.basePackage(this.getBasePackage())).paths(PathSelectors.any()).build().apiInfo(this.apiInfo());
    }

    protected String getBasePackage() {
        return "br.com.fiap.helpers";
    }



}