package com.example.hubNet.repositories.general.banking;

import com.example.hubNet.entities.general.Ecommerce.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bankingBalanceRepository")
public interface BalanceRepository extends JpaRepository<BalanceEntity, Long> {

}