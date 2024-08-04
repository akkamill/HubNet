package com.example.ecommerceDemo.repositories.user.page;

import com.example.ecommerceDemo.entities.user.page.GalleryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository extends JpaRepository<GalleryEntity, Long> {

}
