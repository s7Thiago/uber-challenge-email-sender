package com.thiago.silva.emailservice.infra.ses;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

/**
 * Configura o Spring para instanciar corretamente a classe que integra com o serviço
 * de e-mail da AWS
 *
*/
@Configuration
public class AwsSesConfig {

    @Bean
    AmazonSimpleEmailService amazonSimpleEmailService() {
        return AmazonSimpleEmailServiceClientBuilder.standard()
        .withRegion("us-east-1")
        .build();
    }

}
