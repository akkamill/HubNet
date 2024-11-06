package com.example.ecommerceDemo.repositories.general.analytics;

import com.example.ecommerceDemo.entities.general.analytics.MixtureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixtureRepository extends JpaRepository<MixtureEntity, Long> {

    public List<MixtureEntity> findByUserUserId(Long userId);


}

