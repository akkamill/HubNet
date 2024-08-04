package com.example.ecommerceDemo.services.home;

import com.example.ecommerceDemo.DTO.home.AppPurchaseDTO;
import com.example.ecommerceDemo.DTO.others.ProcessPaymentRequest;
import com.example.ecommerceDemo.DTO.home.PurchaseAndPayment;
import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.entities.home.AppPurchaseEntity;
import com.example.ecommerceDemo.entities.home.enums.PurchaseType;
import com.example.ecommerceDemo.repositories.user.UserRepository;
import com.example.ecommerceDemo.repositories.home.AppPurchaseRepository;
import com.example.ecommerceDemo.services.others.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AppPurchaseService {

    private final AppPurchaseRepository appPurchaseRepository;
    private final UserRepository userRepository;
    private final PaymentService paymentService;

    public AppPurchaseService(AppPurchaseRepository appPurchaseRepository, UserRepository userRepository, PaymentService paymentService) {
        this.appPurchaseRepository = appPurchaseRepository;
        this.userRepository = userRepository;
        this.paymentService = paymentService;
    }

    @Transactional
    public void purchaseAndPay(Long userId, PurchaseAndPayment purchaseAndPayment) {

        AppPurchaseDTO appPurchaseDTO = purchaseAndPayment.getAppPurchaseDTO();
        ProcessPaymentRequest processPaymentRequest = purchaseAndPayment.getProcessPaymentRequest();

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        AppPurchaseEntity appPurchaseEntity = new AppPurchaseEntity();
        appPurchaseEntity.setPurchaseType(appPurchaseDTO.getPurchaseType());
        appPurchaseEntity.setYearly(appPurchaseDTO.isYearly());
        appPurchaseEntity.setUserEntity(userEntity);
        appPurchaseRepository.save(appPurchaseEntity);
//        System.out.println("--------------------------------------" + appPurchaseDTO);

        BigDecimal amount = calculatePurchaseAmount(appPurchaseDTO.getPurchaseType(), appPurchaseDTO.isYearly());
        processPaymentRequest.getPaymentEntity().setPaymentAmount(amount);

        paymentService.processPayment(userId, processPaymentRequest);

    }

    private BigDecimal calculatePurchaseAmount(PurchaseType purchaseType, boolean yearly) {
        BigDecimal amount = switch (purchaseType) {
            case BASIC -> BigDecimal.ZERO;
            case STARTER -> BigDecimal.valueOf(4.99);
            case PREMIUM -> BigDecimal.valueOf(9.99);
        };

        if (yearly) {
            amount = amount.multiply(BigDecimal.valueOf(12).multiply(BigDecimal.valueOf(0.8)));
        }

        return amount;
    }

}

