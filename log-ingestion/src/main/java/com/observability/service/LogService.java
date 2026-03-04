package com.observability.service;

import com.observability.dto.LogRequest;
import com.observability.entity.Log;
import com.observability.entity.TraceId;
import com.observability.producer.LogKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogKafkaProducer logKafkaProducer;

    public void publishLog(LogRequest logRequest, TraceId traceId) {
        Log log = new Log(logRequest.serviceName(), logRequest.level(), traceId, logRequest.message(), logRequest.timestamp());

        logKafkaProducer.send(log);
    }
}
