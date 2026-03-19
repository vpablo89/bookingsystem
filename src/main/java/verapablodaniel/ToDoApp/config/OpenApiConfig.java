package verapablodaniel.ToDoApp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Court Booking System",
                version = "1.0.0",
                description = "API to manage courts and reservations."
        )
)
public class OpenApiConfig {
}

