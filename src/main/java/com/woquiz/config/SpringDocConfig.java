package com.woquiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Woquiz app backend")
                        .description("App who allows to make quizz with word")
                        .contact(new Contact()
                                .name("Achille Deribreux")
                                .email("achille@deribreux.be")))
                .components(new Components())
                .paths(new Paths().addPathItem("/api", new PathItem()));
    }
}

