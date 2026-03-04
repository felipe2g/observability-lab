package com.observability.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.observability.entity.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class LogKafkaProducer {
    private static final String TOPIC = "logs.raw";
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void send(Log event) {
        String json = objectMapper.writeValueAsString(event);
        kafkaTemplate.send(TOPIC, json);
    }
}
