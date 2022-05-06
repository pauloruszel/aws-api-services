package com.cea.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AmazonSQSReceiver {

    @SqsListener(value = "sqs-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void loadMessageFromQueue(String message) {
        log.info("Loading message: {}", message);
    }
}
