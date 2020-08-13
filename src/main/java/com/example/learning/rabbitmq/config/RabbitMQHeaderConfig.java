package com.example.learning.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHeaderConfig {

    @Bean
    Queue cloudAssemblyHeaderQueue() {
        return new Queue("cloudAssemblyHeaderQueue", false);
    }

    @Bean
    Queue serviceBrokerHeaderQueue() {
        return new Queue("serviceBrokerHeaderQueue", false);
    }

    @Bean
    Queue codeStreamHeaderQueue() {
        return new Queue("codeStreamHeaderQueue", false);
    }

    @Bean
    HeadersExchange headerExchange() {
        return new HeadersExchange("header-exchange");
    }

    @Bean
    Binding cloudAssemblyHeadeBinding(Queue cloudAssemblyHeaderQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(cloudAssemblyHeaderQueue).to(headerExchange).where("department").matches("marketing");
    }

    @Bean
    Binding serviceBrokerHeaderBinding(Queue serviceBrokerHeaderQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(serviceBrokerHeaderQueue).to(headerExchange).where("department").matches("finance");
    }

    @Bean
    Binding codeStreamHeaderBinding(Queue codeStreamHeaderQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(codeStreamHeaderQueue).to(headerExchange).where("department").matches("admin");
    }

}