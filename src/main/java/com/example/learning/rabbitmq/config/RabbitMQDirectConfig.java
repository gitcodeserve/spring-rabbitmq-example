package com.example.learning.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

    @Bean
    Queue serviceBrokerQueue() {
        return new Queue("ServiceBrokerQueue", false);
    }

    @Bean
    Queue cloudAssemblyQueue() {
        return new Queue("CloudAssemblyQueue", false);
    }

    @Bean
    Queue codeStreamQueue() {
        return new Queue("CodeStreamQueue", false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("direct-exchange");
    }

    @Bean
    Binding serviceBrokerBinding(Queue serviceBrokerQueue, DirectExchange exchange) {
        return BindingBuilder.bind(serviceBrokerQueue).to(exchange).with("service-borker");
    }

    @Bean
    Binding cloudAssemblyBinding(Queue cloudAssemblyQueue, DirectExchange exchange) {
        return BindingBuilder.bind(cloudAssemblyQueue).to(exchange).with("cloud-assembly");
    }

    @Bean
    Binding codeStreamBinding(Queue codeStreamQueue, DirectExchange exchange) {
        return BindingBuilder.bind(codeStreamQueue).to(exchange).with("code-stream");
    }

}