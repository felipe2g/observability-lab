package com.observability;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(topics = "logs.raw", groupId = "log-processor-group")
    public void consume(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}
