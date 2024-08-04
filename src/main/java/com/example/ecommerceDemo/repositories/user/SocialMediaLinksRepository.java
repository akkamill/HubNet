package com.example.ecommerceDemo.repositories.user;

import com.example.ecommerceDemo.entities.user.SocialMediaLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaLinksRepository extends JpaRepository<SocialMediaLinks, Long> {

}
