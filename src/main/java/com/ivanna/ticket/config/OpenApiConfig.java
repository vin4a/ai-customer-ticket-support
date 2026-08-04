package com.ivanna.ticket.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("AI Ticket Support API").version("1.0")
                        .description("REST API for managing customer support tickets with AI-powered features.")
                        .contact(new Contact().name("Ivanna").email("ivanna.tovar@proton.me")));
    }
}
