package com.example.learning.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

    @Bean
    Queue serviceBrokerFanoutQueue() {
        return new Queue("serviceBrokerFanoutQueue", false);
    }

    @Bean
    Queue cloudAssemblyFanoutQueue() {
        return new Queue("cloudAssemblyFanoutQueue", false);
    }

    @Bean
    Queue codeStreamFanoutQueue() {
        return new Queue("codeStreamFanoutQueue", false);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-exchange");
    }

    @Bean
    Binding serviceBrokerFanoutBinding(Queue serviceBrokerFanoutQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(serviceBrokerFanoutQueue).to(exchange);
    }

    @Bean
    Binding cloudAssemblyFanoutBinding(Queue cloudAssemblyFanoutQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(cloudAssemblyFanoutQueue).to(exchange);
    }

    @Bean
    Binding codeStreamFanoutBinding(Queue codeStreamFanoutQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(codeStreamFanoutQueue).to(exchange);
    }

}