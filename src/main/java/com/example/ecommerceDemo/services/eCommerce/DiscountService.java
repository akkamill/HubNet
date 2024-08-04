package com.example.ecommerceDemo.services.eCommerce;

import com.example.ecommerceDemo.DTO.eCommerce.DiscountCodesDTO;
import com.example.ecommerceDemo.entities.eCommerce.DiscountCodes;
import com.example.ecommerceDemo.repositories.eCommerce.DiscountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;

    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }


    @Transactional
    public BigDecimal calculateDiscountCode(String enteredCode, BigDecimal totalPrice) {

        DiscountCodes discountCode = discountRepository.findByDiscountCode(enteredCode);

        if (discountCode != null) {
            if (!isExpired(discountCode) && !isUsageLimitReached(discountCode)) {
                discountCode.setUsageCount(discountCode.getUsageCount() + 1);
                discountRepository.save(discountCode);
            }

            BigDecimal discountAmount = BigDecimal.ZERO;

            switch (discountCode.getDiscountType()) {
                case PERCENTAGE:
                    discountAmount = totalPrice.multiply(discountCode.getDiscountAmount().divide
                            (BigDecimal.valueOf(100)));
                    break;
                case AMOUNT:
                    if (totalPrice.compareTo(discountCode.getDiscountAmount()) >= 0) {
                        discountAmount = discountCode.getDiscountAmount();
                    }
                    break;
                default:
                    break;
            }
            return discountAmount;
        }
        return BigDecimal.ZERO;
    }

    public DiscountCodes createDiscountCode(DiscountCodesDTO discountCodeDTO) {
        DiscountCodes discountCode = toEntity(discountCodeDTO);
        return discountRepository.save(discountCode);
    }


    private boolean isExpired(DiscountCodes discountCode) {
        LocalDateTime expirationDate = discountCode.getExpirationDate();
        return expirationDate != null && expirationDate.isBefore(LocalDateTime.now());
    }

    private boolean isUsageLimitReached(DiscountCodes discountCode) {
        return discountCode.getUsageCount() >= discountCode.getUsageLimit();
    }

    //---------------------------------------------------------------------------------------------------------------//


    public DiscountCodesDTO toDTO(DiscountCodes discountCode) {
        DiscountCodesDTO discountCodeDTO = new DiscountCodesDTO();
        discountCodeDTO.setDiscountId(discountCode.getDiscountId());
        discountCodeDTO.setDiscountCode(discountCode.getDiscountCode());
        discountCodeDTO.setDiscountAmount(discountCode.getDiscountAmount());
        discountCodeDTO.setUsageLimit(discountCode.getUsageLimit());
        discountCodeDTO.setExpirationDate(discountCode.getExpirationDate());
        discountCodeDTO.setDiscountType(discountCode.getDiscountType());
        return discountCodeDTO;
    }

    public DiscountCodes toEntity(DiscountCodesDTO discountCodeDTO) {
        DiscountCodes discountCode = new DiscountCodes();
        discountCode.setDiscountCode(discountCodeDTO.getDiscountCode());
        discountCode.setDiscountAmount(discountCodeDTO.getDiscountAmount());
        discountCode.setUsageLimit(discountCodeDTO.getUsageLimit());
        discountCode.setExpirationDate(discountCodeDTO.getExpirationDate());
        discountCode.setDiscountType(discountCodeDTO.getDiscountType());
        return discountCode;
    }


}
