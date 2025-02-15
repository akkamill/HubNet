package com.example.hubNet.repositories.others;

import com.example.hubNet.entities.others.DebitCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCardEntity, Long> {

    Optional<DebitCardEntity> findByCardNumber(String enteredNumber);


}
