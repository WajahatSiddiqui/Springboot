package com.wajahat.learn.spring.amqp.rabbitmqmessaging.service;

import com.wajahat.learn.spring.amqp.rabbitmqmessaging.config.MessagingConfiguration;
import com.wajahat.learn.spring.amqp.rabbitmqmessaging.domain.CustomMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by wajahat on 17/5/17.
 */
@Service
public class CustomMessageSender {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageSender.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public CustomMessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // executes every 100 msecs
    @Scheduled(fixedDelay = 100L)
    public void sendMessage() {
        final CustomMessage customMessage = new CustomMessage("Hello Wajahat", new Random().nextInt(50), false);
        log.info("Sending customMessage: " + customMessage);
        rabbitTemplate.convertAndSend(MessagingConfiguration.EXCHANGE_NAME,
                MessagingConfiguration.ROUTING_KEY, customMessage);
    }
}
