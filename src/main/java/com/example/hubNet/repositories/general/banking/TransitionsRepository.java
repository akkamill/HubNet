package com.example.hubNet.repositories.general.banking;

import com.example.hubNet.entities.general.banking.TransitionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransitionsRepository extends JpaRepository<TransitionsEntity, Long> {

}