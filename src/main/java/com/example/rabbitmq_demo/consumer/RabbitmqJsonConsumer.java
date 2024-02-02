package com.example.rabbitmq_demo.consumer;

import com.example.rabbitmq_demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitmqJsonConsumer {
    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consumeJsonMessage(User user) {
        log.info("Message received from the RabbitMQ JavaInUse JSON: " + user.toString());
    }
}
