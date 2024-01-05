package ws.probal.creditcardapp.common.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi creditCardApi() {
        return GroupedOpenApi.builder()
                .group("ws.probal.creditcardapp")
                .pathsToMatch("/api/v1/**")
                .build();
    }
}
