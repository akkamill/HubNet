package com.example.ecommerceDemo.services;

import com.example.ecommerceDemo.DTO.DebitCardDTO;
import com.example.ecommerceDemo.entities.DebitCardEntity;
import com.example.ecommerceDemo.entities.PaymentEntity;
import com.example.ecommerceDemo.enums.PaymentMethods;
import com.example.ecommerceDemo.enums.PaymentStatus;
import com.example.ecommerceDemo.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final DebitCardService debitCardService;

    public PaymentService(PaymentRepository paymentRepository, DebitCardService debitCardService) {
        this.paymentRepository = paymentRepository;
        this.debitCardService = debitCardService;
    }

    public PaymentEntity processPayment(PaymentEntity paymentEntity, DebitCardDTO debitCardDTO) {
        if (paymentEntity.getPaymentMethods() == PaymentMethods.DEBIT_CARD) {

            boolean isValid = debitCardService.checkDetails(debitCardDTO);
            if (!isValid) {
                throw new RuntimeException("Invalid card details");
            }
            paymentEntity.setPaymentStatus(PaymentStatus.SUCCESSFUL);
        } else if (paymentEntity.getPaymentMethods() == PaymentMethods.CASH_ON_DELIVERY) {
            paymentEntity.setPaymentStatus(PaymentStatus.PENDING);
        }
        return paymentRepository.save(paymentEntity);
    }

}
