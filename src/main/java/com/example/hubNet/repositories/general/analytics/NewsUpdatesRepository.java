package com.example.hubNet.repositories.general.analytics;

import com.example.hubNet.entities.general.analytics.NewsUpdatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsUpdatesRepository extends JpaRepository<NewsUpdatesEntity, Long> {

    public List<NewsUpdatesEntity> findByUserUserId(Long userId);

}
