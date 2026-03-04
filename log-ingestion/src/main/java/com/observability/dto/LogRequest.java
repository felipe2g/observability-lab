package com.observability.dto;

import com.observability.entity.LogLevel;
import com.observability.entity.TraceId;

import java.time.Instant;

public record LogRequest(
        String serviceName,
        LogLevel level,
        String message,
        Instant timestamp
) {}
