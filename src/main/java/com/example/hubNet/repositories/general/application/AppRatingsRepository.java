package com.example.hubNet.repositories.general.application;


import com.example.hubNet.entities.general.application.AppRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRatingsRepository extends JpaRepository<AppRatings, Long> {

}
