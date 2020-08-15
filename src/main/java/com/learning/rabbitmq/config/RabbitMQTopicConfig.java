package com.learning.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    @Bean
    Queue serviceBrokerTQueue() {
        return new Queue("ServiceTBrokerQueue", false);
    }

    @Bean
    Queue cloudAssemblyTQueue() {
        return new Queue("CloudTAssemblyQueue", false);
    }

    @Bean
    Queue codeStreamTQueue() {
        return new Queue("CodeTStreamQueue", false);
    }

    @Bean
    Queue allQueue() {
        return new Queue("allQueue", false);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");
    }

    @Bean
    Binding serviceBrokerTBinding(Queue serviceBrokerTQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(serviceBrokerTQueue).to(topicExchange).with("queue.service-borker");
    }

    @Bean
    Binding cloudAssemblyTBinding(Queue cloudAssemblyTQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(cloudAssemblyTQueue).to(topicExchange).with("queue.cloud-assembly");
    }

    @Bean
    Binding codeStreamTBinding(Queue codeStreamTQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(codeStreamTQueue).to(topicExchange).with("queue.code-stream");
    }
    @Bean
    Binding allBinding(Queue allQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(allQueue).to(topicExchange).with("queue.*");
    }

}