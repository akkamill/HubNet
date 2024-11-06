package com.example.ecommerceDemo.repositories.general;

import com.example.ecommerceDemo.entities.general.ActiveUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveUsersRepository extends JpaRepository<ActiveUsers, Long> {

}
