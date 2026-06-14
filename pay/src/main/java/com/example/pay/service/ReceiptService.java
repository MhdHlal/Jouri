package com.example.pay.service;

import com.example.pay.models.Receipt;
import com.example.pay.repository.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceiptService {
    private final ReceiptRepository receiptRepository;

    public void addReceipt (Receipt receipt){
        receiptRepository.insert(receipt);
    }

    public List <Receipt> getAllReceipt(){
        return receiptRepository.findAll();
    }
}
