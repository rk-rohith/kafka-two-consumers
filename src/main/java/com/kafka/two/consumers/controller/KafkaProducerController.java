package com.kafka.two.consumers.controller;

import com.kafka.two.consumers.model.User;
import com.kafka.two.consumers.service.KafKaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/kafka")
public class KafkaProducerController {
    private final KafKaProducerService producerService;

    @PostMapping(value = "/createUser")
    public void sendMessageToKafkaTopic(@RequestBody User user) {
        log.info("Input Parameter User {}", user);
        producerService.createUser(user);
    }
}