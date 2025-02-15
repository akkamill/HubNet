package com.example.hubNet.repositories.general.analytics;

import com.example.hubNet.entities.general.analytics.ConversionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversionRepository extends JpaRepository<ConversionEntity, Long> {

    public List<ConversionEntity> findByUserUserId(Long userId);

}