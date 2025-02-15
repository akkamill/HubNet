package com.example.hubNet.repositories.general.users;

import com.example.hubNet.entities.general.users.ActiveUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveUsersRepository extends JpaRepository<ActiveUsers, Long> {

}
