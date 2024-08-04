package com.example.ecommerceDemo.repositories.user.page;

import com.example.ecommerceDemo.entities.user.page.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

}
