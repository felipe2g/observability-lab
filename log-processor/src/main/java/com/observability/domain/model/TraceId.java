package com.observability.domain.model;

import java.util.UUID;

public record TraceId(String value) {
    public TraceId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("TraceId cannot be null or blank");
        }
    }

    public static TraceId generate() {
        return new TraceId(UUID.randomUUID().toString());
    }
}
