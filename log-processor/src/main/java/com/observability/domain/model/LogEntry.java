package com.observability.domain.model;

import java.time.Instant;

public record LogEntry(
        String serviceName,
        LogLevel level,
        TraceId traceId,
        String message,
        Instant timestamp
) {}
