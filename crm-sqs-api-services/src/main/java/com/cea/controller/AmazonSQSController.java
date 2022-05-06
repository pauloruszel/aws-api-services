package com.cea.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AmazonSQSController {

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public AmazonSQSController(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;


    @GetMapping("/send/{msg}")
    public void sendMessageToQueue(@PathVariable("msg") String message) {
        log.info("Receiving message: " + message);
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(message).build());

    }

}
