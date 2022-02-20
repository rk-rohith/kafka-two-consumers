package com.kafka.two.consumers.service;

import com.kafka.two.consumers.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafKaProducerService {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${spring.kafka.consumer.topic.name}")
    private String userTopicName; //Topic with user object payload

    @Autowired
    private KafkaTemplate<String, User> userKafkaTemplate;

    public void createUser(User user) {
        try {
            userKafkaTemplate.send(userTopicName, user);

        } catch (Exception e) {
            log.info("Error occurred while publishing the invoice to message broker");
            throw e;
        }
    }
}
