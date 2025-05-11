package cat.ycamacho.freetable_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Freetable API")
                .description("Documentación de la API freetable")
                .version("1.0.0")
                .contact(new Contact().name("Yostin Camacho").email("yosarca@gmail.com")));
    }
}