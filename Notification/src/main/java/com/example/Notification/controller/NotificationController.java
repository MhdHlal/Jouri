package com.example.Notification.controller;

import com.example.Notification.config.MessagingConfig;
import com.example.Notification.models.ReceiptStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationController {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(ReceiptStatus receiptStatus){
        System.out.println("Message recieved from queue: "+receiptStatus);
    }
}
