package com.example.hubNet.repositories.general.users;

import com.example.hubNet.entities.general.users.DownloadsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DownloadsRepository extends JpaRepository<DownloadsEntity, Long> {

    List<DownloadsEntity> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

}