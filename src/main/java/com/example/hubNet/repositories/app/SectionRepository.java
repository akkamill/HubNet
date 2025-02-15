package com.example.hubNet.repositories.app;


import com.example.hubNet.entities.app.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SectionRepository extends JpaRepository<SectionEntity, Long> {

}
