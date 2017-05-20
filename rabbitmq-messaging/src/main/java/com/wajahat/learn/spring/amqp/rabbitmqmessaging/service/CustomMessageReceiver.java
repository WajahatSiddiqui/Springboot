package com.wajahat.learn.spring.amqp.rabbitmqmessaging.service;

import com.wajahat.learn.spring.amqp.rabbitmqmessaging.config.MessagingConfiguration;
import com.wajahat.learn.spring.amqp.rabbitmqmessaging.domain.CustomMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created by wajahat on 17/5/17.
 */
@Service
public class CustomMessageReceiver {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageReceiver.class);

    @RabbitListener(queues = MessagingConfiguration.GENERIC_MESSAGE_QUEUE)
    public void receiveMessage(Message message) {
        log.info("Generic message received: " + message);
    }

    @RabbitListener(queues = MessagingConfiguration.SPECIFIC_MESSAGE_QUEUE)
    public void receiveMessage(CustomMessage message) {
        log.info("Specific message received: " + message);
    }
}
