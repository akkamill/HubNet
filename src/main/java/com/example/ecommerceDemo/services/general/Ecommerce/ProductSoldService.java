package com.example.ecommerceDemo.services.general.Ecommerce;

import com.example.ecommerceDemo.DTO.general.Ecommerce.ProductSoldDTO;
import com.example.ecommerceDemo.entities.general.Ecommerce.ProductSold;
import com.example.ecommerceDemo.repositories.general.Ecommerce.ProductSoldRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;

@Service
public class ProductSoldService {

    private final ProductSoldRepository productSoldRepository;

    public ProductSoldService(ProductSoldRepository productSoldRepository) {
        this.productSoldRepository = productSoldRepository;
    }

    public ProductSoldDTO getQuantity(Long productSoldId) {

        ProductSold productSold = productSoldRepository.findById(productSoldId).orElseThrow(()
                -> new RuntimeException("Product quantity not found"));

        return convertToDTO(productSold);
    }


    public double compareWeeklySoldProducts() {
        LocalDateTime startOfCurrentWeek = LocalDateTime.now().with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        LocalDateTime endOfCurrentWeek = startOfCurrentWeek.plusWeeks(1);

        LocalDateTime startOfLastWeek = startOfCurrentWeek.minusWeeks(1);
        LocalDateTime endOfLastWeek = startOfCurrentWeek;

        int currentWeekSoldQuantity = productSoldRepository.countSoldProductsCurrentWeek(startOfCurrentWeek, endOfCurrentWeek);
        int lastWeekSoldQuantity = productSoldRepository.countSoldProductsCurrentWeek(startOfLastWeek, endOfLastWeek);

        if (lastWeekSoldQuantity == 0) {
            return currentWeekSoldQuantity > 0 ? 100.0 : 0.0;
        }

        return ((double) currentWeekSoldQuantity - lastWeekSoldQuantity) / lastWeekSoldQuantity * 100;
    }

    public Map<String, Integer> getSoldQuantityByGenderAllTime() {
        return productSoldRepository.countSoldProductsByGenderAllTime();
    }






    // --------------------------------------------------------------------------------------------------------------//

    public static ProductSoldDTO convertToDTO(ProductSold productSold) {
        if (productSold == null) {
            return null;
        }
        ProductSoldDTO dto = new ProductSoldDTO();
        dto.setProductSoldId(productSold.getProductSoldId());
        dto.setProductSoldQuantity(productSold.getProductSoldQuantity());
        dto.setSaleByGender(productSold.getSaleByGender());
        return dto;
    }

    // Method to convert DTO back to ProductSold
    public static ProductSold convertToEntity(ProductSoldDTO dto) {
        if (dto == null) {
            return null;
        }
        ProductSold productSold = new ProductSold();
        productSold.setProductSoldId(dto.getProductSoldId());
        productSold.setProductSoldQuantity(dto.getProductSoldQuantity());
        productSold.setSaleByGender(dto.getSaleByGender());

        return productSold;
    }
}
