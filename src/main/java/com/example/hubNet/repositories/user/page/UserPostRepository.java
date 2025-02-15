package com.example.hubNet.repositories.user.page;

import com.example.hubNet.entities.user.page.UserPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostRepository  extends JpaRepository<UserPostEntity, Long> {

}
