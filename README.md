# spring-rabbitmq-example
Spring boot based RabbitMQ example


To create different types of exchanges on running the spring boot application - fire following rest GET API.

http://localhost:8080/rabbitmq/direct/producer?exchangeName=direct-exchange&routingKey=admin&messageData=HelloDirectExchange

http://localhost:8080/rabbitmq/fanout/producer?exchangeName=topic-exchange&routingKey=admin&messageData=HelloTopicExchange

http://localhost:8080/rabbitmq/fanout/producer?exchangeName=fanout-exchange&routingKey=admin&messageData=HelloFanoutExchange

http://localhost:8080/rabbitmq/fanout/producer?exchangeName=header-exchange&routingKey=admin&messageData=HelloHeaderExchange
