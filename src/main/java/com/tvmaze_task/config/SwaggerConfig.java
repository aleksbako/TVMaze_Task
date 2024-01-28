package com.tvmaze_task.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;



@Configuration
@OpenAPIDefinition (
        info = @Info(
                contact = @Contact(
                        name="Aleks Bako",
                        email="aleksbako@outlook.com"
                ),
                description = "This is a task for Payex.",
                title = "OpenAPI for this application."


        ),
        security = @SecurityRequirement(
                name = "Authorization"
        )
)
@SecurityScheme(
        name="Authorization",
        description = "Add authentication by using api key",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "apikey",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {}