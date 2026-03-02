package com.observability.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/logs")
public class LogController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public ResponseEntity<String> receive(@RequestBody String log) {

        restTemplate.postForObject(
                "http://log-processor:8081/process",
                log,
                String.class
        );

        return ResponseEntity.ok("received");
    }
}
