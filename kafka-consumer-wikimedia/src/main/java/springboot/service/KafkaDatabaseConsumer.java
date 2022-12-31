package springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author khiemnd5
 * @since : 12/31/22, Sat
 */

@Slf4j
@Service
public class KafkaDatabaseConsumer {

    @KafkaListener(topics = "topic-wikimedia", groupId = "my_group")
    private void consumer(String eventMsg) {
        log.info(String.format("Event message recived -> %s", eventMsg));
    }
}
