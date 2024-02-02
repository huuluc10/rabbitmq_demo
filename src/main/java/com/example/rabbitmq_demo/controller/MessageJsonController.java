package com.example.rabbitmq_demo.controller;

import com.example.rabbitmq_demo.model.User;
import com.example.rabbitmq_demo.publisher.RabbitmqJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
    public MessageJsonController(RabbitmqJsonProducer rabbitmqJsonProducer) {
        this.rabbitmqJsonProducer = rabbitmqJsonProducer;
    }

    private RabbitmqJsonProducer rabbitmqJsonProducer;

    @PostMapping("/publishJson")
    public ResponseEntity<String> setMessageJson(@RequestBody User user) {
        rabbitmqJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Message sent to the RabbitMQ JavaInUse Successfully");
    }
}
