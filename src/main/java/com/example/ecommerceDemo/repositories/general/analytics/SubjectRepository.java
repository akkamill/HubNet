package com.example.ecommerceDemo.repositories.general.analytics;

import com.example.ecommerceDemo.entities.general.analytics.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {

    List<SubjectEntity> findByUserUserId(Long userId);


}
