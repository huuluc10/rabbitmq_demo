package com.example.rabbitmq_demo.publisher;

import com.example.rabbitmq_demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitmqJsonProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("${rabbitmq.routing.json.key}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    public RabbitmqJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user) {
        log.info("Sending message to the queue using JSON ->  {}", user.toString());
        rabbitTemplate.convertAndSend(exchangeName, routingKey, user);
    }
}
