package com.example.hubNet.repositories.general.analytics;

import com.example.hubNet.entities.general.analytics.VisitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitsRepository extends JpaRepository<VisitsEntity, Long> {


    @Query(value = "SELECT * FROM visits WHERE visit_country = :country", nativeQuery = true)
    List<VisitsEntity> findByVisitCountry(String country);

    @Query("SELECT COUNT(v) FROM visits v WHERE YEAR(v.visitDate) = YEAR(CURRENT_DATE) - 1")
    Long getTotalVisitsForLastYear();

    @Query("SELECT COUNT(v) FROM visits v WHERE YEAR(v.visitDate) = YEAR(CURRENT_DATE)")
    Long getTotalVisitsForCurrentYear();


}