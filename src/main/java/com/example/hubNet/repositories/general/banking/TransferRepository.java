package com.example.hubNet.repositories.general.banking;

import com.example.hubNet.entities.general.banking.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, Long> {

}