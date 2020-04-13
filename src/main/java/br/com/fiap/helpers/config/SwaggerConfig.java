package br.com.fiap.helpers.config;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfig.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends SwaggerConfigBase {

    @Override
    protected String getInfoTitle() {
        return "API ";
    }

    @Override
    protected String getDescriptionAPI() {
        return "API";
    }

}
