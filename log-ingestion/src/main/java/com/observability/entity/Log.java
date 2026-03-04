package com.observability.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Log {
    private String serviceName;
    private LogLevel level;
    private TraceId traceId;
    private String message;
    private Instant timestamp;
}
