package com.wajahat.learn.spring.amqp.rabbitmqmessaging.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

/**
 * Created by wajahat on 17/5/17.
 */

@Configuration
public class MessagingConfiguration implements RabbitListenerConfigurer {
    public static final String EXCHANGE_NAME = "mqExchange";
    public static final String ROUTING_KEY = "messages.key";
    public static final String GENERIC_MESSAGE_QUEUE = "mqGenericQueue";
    public static final String SPECIFIC_MESSAGE_QUEUE = "mqSpecificQueue";

    @Bean
    public TopicExchange mqExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue mqGenericQueue() {
        return new Queue(GENERIC_MESSAGE_QUEUE);
    }

    @Bean
    public Queue mqSpecificQueue() {
        return new Queue(SPECIFIC_MESSAGE_QUEUE);
    }

    @Bean
    public Binding declareBindingGeneric() {
        return BindingBuilder.bind(mqGenericQueue()).to(mqExchange()).with(ROUTING_KEY);
    }

    @Bean
    public Binding declareBindingSpecific() {
        return BindingBuilder.bind(mqSpecificQueue()).to(mqExchange()).with(ROUTING_KEY);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }

    @Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(consumerJackson2MessageConverter());
        return factory;
    }


    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }
}
