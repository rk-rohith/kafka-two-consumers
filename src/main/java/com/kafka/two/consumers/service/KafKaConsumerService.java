package com.kafka.two.consumers.service;

import com.kafka.two.consumers.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafKaConsumerService {

    @Value(value = "${spring.kafka.consumer.group-id.id1}")
    private String userGroupId1;

    @Value(value = "${spring.kafka.consumer.group-id.id2}")
    private String userGroupId2;

    @KafkaListener(topics = "${spring.kafka.consumer.topic.name}", groupId = "${spring.kafka.consumer.group-id.id1}")
    public void consumer(User user) {
        log.info("groupId -> {}", userGroupId1);
        log.info("User created -> {}", user);
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic.name}", groupId = "${spring.kafka.consumer.group-id.id2}")
    public void consume(User user) {
        log.info("groupId -> {}", userGroupId2);
        log.info("User created -> {}", user);
    }
}
