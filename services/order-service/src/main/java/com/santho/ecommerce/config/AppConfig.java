package com.santho.ecommerce.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class AppConfig {
    @Bean
    NewTopic topic() {
        return TopicBuilder
                .name("order-topic")
                .build();
    }
}
