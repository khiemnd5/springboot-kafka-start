package vn.edu.stepup.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author khiemnd5
 * @since : 12/30/22, Fri
 */

@Configuration
public class KafkaTopocConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("topic-wikimedia")
                .build();
    }
}
