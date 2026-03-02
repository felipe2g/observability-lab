package com.observability.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process")
public class ProcessorController {

    @PostMapping
    public ResponseEntity<String> process(@RequestBody String log) {
        System.out.println("Processing: " + log);
        return ResponseEntity.ok("processed");
    }
}
