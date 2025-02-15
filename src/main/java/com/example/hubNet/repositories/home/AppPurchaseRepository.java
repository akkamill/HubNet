package com.example.hubNet.repositories.home;

import com.example.hubNet.entities.home.AppPurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppPurchaseRepository extends JpaRepository<AppPurchaseEntity, Long> {

}
