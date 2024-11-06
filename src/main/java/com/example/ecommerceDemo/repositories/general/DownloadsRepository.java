package com.example.ecommerceDemo.repositories.general;

import com.example.ecommerceDemo.entities.general.DownloadsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DownloadsRepository extends JpaRepository<DownloadsEntity, Long> {

    List<DownloadsEntity> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

}