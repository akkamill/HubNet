package com.example.ecommerceDemo.services.others;

import com.example.ecommerceDemo.DTO.app.EmailDTO;
import com.example.ecommerceDemo.DTO.others.ProcessPaymentRequest;
import com.example.ecommerceDemo.entities.others.PaymentEntity;
import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.enums.PaymentMethods;
import com.example.ecommerceDemo.enums.PaymentStatus;
import com.example.ecommerceDemo.repositories.others.PaymentRepository;
import com.example.ecommerceDemo.repositories.user.UserRepository;
import com.example.ecommerceDemo.services.app.EmailService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final DebitCardService debitCardService;
    private final UserRepository userRepository;
    private final EmailService emailService;

    public PaymentService(PaymentRepository paymentRepository,
                          DebitCardService debitCardService,
                          UserRepository userRepository, EmailService emailService) {
        this.paymentRepository = paymentRepository;
        this.debitCardService = debitCardService;
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public PaymentEntity processPayment(Long userId, ProcessPaymentRequest processPaymentRequest) {

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        PaymentEntity paymentEntity = processPaymentRequest.getPaymentEntity();
        paymentEntity.setUserPayment(userEntity);

        PaymentMethods paymentMethods = paymentEntity.getPaymentMethods();

        if (paymentMethods == PaymentMethods.DEBIT_CARD) {
            boolean isValid = debitCardService.checkDetails(processPaymentRequest.getDebitCardDTO());
            if (!isValid) {
                throw new RuntimeException("Invalid card details");
            }
            paymentEntity.setPaymentStatus(PaymentStatus.SUCCESSFUL);
        } else if (paymentMethods == PaymentMethods.CASH_ON_DELIVERY) {
            paymentEntity.setPaymentStatus(PaymentStatus.PENDING);
        } else {
            throw new RuntimeException("Unavailable payment method");
        }

//        if(paymentEntity.getPaymentStatus() == PaymentStatus.SUCCESSFUL) {
//            sendPaymentConfirmationEmail(userEntity.getEmailAddress(), paymentEntity);
//        }

        return paymentRepository.save(paymentEntity);
    }

    public void sendPaymentConfirmationEmail(Long userId, String userEmail, PaymentEntity paymentEntity) {

        String subject = "Payment Confirmation";
        String body = "Thank you for purchase. Your payment was successful. \n" +
                "Invoice Details:\n" +
                "Payment ID: " + paymentEntity.getPaymentId() + "\n" +
                "Amount: " + paymentEntity.getPaymentAmount() + "\n" +
                "Payment Method: " + paymentEntity.getPaymentMethods();

        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setSenderEmail("coders@localhost.com");
        emailDTO.setSubject(subject);
        emailDTO.setBody(body);
        emailDTO.setRecipientEmailAddresses(Collections.singletonList(userEmail));

        emailService.sendEmail(userId, emailDTO);

    }


//    public PaymentEntity processPaymentTest(Long userId, BigDecimal amount) {
//
//        UserEntity userEntity = appPurchaseService.findByUserId(userId);
//
//        PaymentEntity paymentEntity = (PaymentEntity) userEntity.getPayments();
//        paymentEntity.setUserPayment(userEntity);
//
//        PaymentMethods paymentMethods = paymentEntity.getPaymentMethods();
//
//        if (paymentMethods == PaymentMethods.DEBIT_CARD) {
//            boolean isValid = debitCardService.checkDetails(null);
//
//            if (!isValid) {
//                throw new RuntimeException("Invalid card details");
//            }
//            paymentEntity.setPaymentStatus(PaymentStatus.SUCCESSFUL);
//            paymentEntity.setPaymentAmount(amount);
//        } else if (paymentMethods == PaymentMethods.CASH_ON_DELIVERY) {
//            paymentEntity.setPaymentStatus(PaymentStatus.PENDING);
//        } else {
//            throw new RuntimeException("Unavailable payment method");
//        }
//
//
//        return paymentRepository.save(paymentEntity);
//    }
}
