package com.example.rabbitmq_demo.controller;

import com.example.rabbitmq_demo.publisher.RabbitmqProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    public MessageController(RabbitmqProducer rabbitmqProducer) {
        this.rabbitmqProducer = rabbitmqProducer;
    }

    private RabbitmqProducer rabbitmqProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message) {
        rabbitmqProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the RabbitMQ JavaInUse Successfully");
    }
}
