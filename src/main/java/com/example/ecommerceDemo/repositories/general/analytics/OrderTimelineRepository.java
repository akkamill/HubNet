package com.example.ecommerceDemo.repositories.general.analytics;

import com.example.ecommerceDemo.entities.general.analytics.OrderTimelineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderTimelineRepository extends JpaRepository<OrderTimelineEntity, Long> {

    public List<OrderTimelineEntity> findByUserUserId(Long userId);


}
