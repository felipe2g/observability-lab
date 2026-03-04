package com.observability.controller;

import com.observability.dto.LogRequest;
import com.observability.entity.TraceId;
import com.observability.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @PostMapping
    public ResponseEntity<Void> createLog(
            @RequestAttribute("traceId") TraceId traceId,
            @RequestBody LogRequest logEntry
    ) {
        logService.publishLog(logEntry, traceId);
        return ResponseEntity.accepted().build();
    }
}
