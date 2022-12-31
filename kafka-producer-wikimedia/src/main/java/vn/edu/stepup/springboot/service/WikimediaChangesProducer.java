package vn.edu.stepup.springboot.service;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * @author khiemnd5
 * @since : 12/30/22, Fri
 */

@Slf4j
@Service
public class WikimediaChangesProducer {
    private KafkaTemplate<String, String> kafkaTemplate;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage() throws InterruptedException {
        String topic = "topic-wikimedia";

        BackgroundEventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        BackgroundEventSource eventSource = new BackgroundEventSource.Builder(eventHandler, new EventSource.Builder(URI.create(url))).build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(1000);
    }
}
