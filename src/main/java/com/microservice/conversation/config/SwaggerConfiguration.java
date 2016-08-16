
//Namespace
package com.microservice.conversation.config;

//Imports
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.*;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Configuration class for Swagger
 */
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("rest-api")
                .apiInfo(apiInfo())
                .select()
                .paths(paths())
                .build()
                .enableUrlTemplating(false);
    }



    private Predicate<String> paths() {

        return and(
                or(regex("/rest.*"), regex("/testing.*")),
                not(hiddenPaths())
        );
    }

    private Predicate<String> hiddenPaths() {
        return or(
                regex("/upload*"),
                regex("/rest/v1/about"),
                regex("/rest/v1/checkdb"),
                regex("/error*"),
                regex("/restart*"),
                regex("/example*")
        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Conversation Service API")
                .description("This page documents the API for conversation project.")
                .contact(new Contact("Gabriel Novoa Bonet", "", ""))
                .build();
    }

}
