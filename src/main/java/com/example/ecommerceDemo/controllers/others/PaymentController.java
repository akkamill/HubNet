package com.example.ecommerceDemo.controllers.others;


import com.example.ecommerceDemo.DTO.others.ProcessPaymentRequest;
import com.example.ecommerceDemo.entities.others.PaymentEntity;
import com.example.ecommerceDemo.services.others.PaymentService;
import com.example.ecommerceDemo.services.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;
    private final UserService userService;

    public PaymentController(PaymentService paymentService, UserService userService) {
        this.paymentService = paymentService;
        this.userService = userService;
    }


    @PostMapping("/process/{userId}")
    public ResponseEntity<String> processPayment(@PathVariable Long userId,
                                                 @RequestBody ProcessPaymentRequest processPaymentRequest) {
        try {
            PaymentEntity paymentEntity = paymentService.processPayment(userId, processPaymentRequest);
            return ResponseEntity.ok("Payment processed successfully. Payment ID: " + paymentEntity.getPaymentId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process payment " + e.getMessage());
        }

    }

//    @PostMapping("/process")
//    public ResponseEntity<PaymentEntity> processPayment(@RequestBody ProcessPaymentRequest request) {
//        PaymentEntity processPayment = paymentService.processPayment(
//                request.getPaymentEntity(),
//                request.getDebitCardDTO());
//        return ResponseEntity.ok(processPayment);
//    }
}
