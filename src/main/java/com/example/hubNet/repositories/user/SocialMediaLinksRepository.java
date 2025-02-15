package com.example.hubNet.repositories.user;

import com.example.hubNet.entities.user.SocialMediaLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaLinksRepository extends JpaRepository<SocialMediaLinks, Long> {

}
