package com.example.ecommerceDemo.repositories.general;

import com.example.ecommerceDemo.entities.general.InstallmentsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InstallmentsRepository extends JpaRepository<InstallmentsEntity, Long> {


    @Query("SELECT i.mainlands, COUNT(i) FROM installments i GROUP BY i.mainlands")
    List<Object[]> countByMainlandsGroupBy();


    @Query(value = "SELECT i.countries, COUNT(i.installmentId) AS totalInstallments " +
            "FROM installments i " +
            "GROUP BY i.countries " +
            "ORDER BY totalInstallments DESC")
    List<Object[]> findTopInstallmentsByCountry(Pageable pageable);


    long countByCreatedAtAfter(LocalDateTime date);
}
