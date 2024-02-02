package com.example.rabbitmq_demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitmqConsumer {
    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeMessage(String message) {
        log.info("Message received from the RabbitMQ JavaInUse: " + message);
    }
}
