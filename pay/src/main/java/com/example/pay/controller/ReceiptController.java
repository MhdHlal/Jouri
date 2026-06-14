package com.example.pay.controller;

import com.example.pay.config.MessagingConfig;
import com.example.pay.models.Receipt;
import com.example.pay.models.ReceiptStatus;
import com.example.pay.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class ReceiptController {

    private final ReceiptService receiptService;

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{name}")
    public String addReceipt(@RequestBody Receipt receipt,@PathVariable String name){
        receipt.setReceiptId(UUID.randomUUID().toString());
        receiptService.addReceipt(receipt);
        ReceiptStatus receiptStatus =new ReceiptStatus(receipt,"PROCESS", "payment process is success "+ name);
        template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,receiptStatus);
        return "success!!";
    }

    @GetMapping
    public ResponseEntity<List<Receipt>> getAllReceipts(){
        return ResponseEntity.ok(receiptService.getAllReceipt());
    }

    @GetMapping("/get")
    public String getReceiptDetails(){return "Receipt Details: 0.0 s.p (لشو البعزقة سيد راسي!)";}


}
