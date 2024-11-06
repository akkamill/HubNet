package com.example.ecommerceDemo.repositories.general.Ecommerce;

import com.example.ecommerceDemo.entities.general.Ecommerce.ProductSold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;

import java.time.LocalDateTime;
import java.util.Map;

@EnableReactiveMethodSecurity
public interface ProductSoldRepository extends JpaRepository<ProductSold, Long> {

    @Query("SELECT ps.saleByGender, SUM(ps.productSoldQuantity) FROM product_quantity ps GROUP BY ps.saleByGender")
    Map<String, Integer> countSoldProductsByGenderAllTime();

    @Query("SELECT SUM(ps.productSoldQuantity) FROM product_quantity ps WHERE ps.saleDate BETWEEN ?1 AND ?2")
    Integer countSoldProductsCurrentWeek(LocalDateTime startDate, LocalDateTime endDate);

}
