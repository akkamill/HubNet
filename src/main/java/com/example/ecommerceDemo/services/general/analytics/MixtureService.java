package com.example.ecommerceDemo.services.general.analytics;


import com.example.ecommerceDemo.entities.general.analytics.MixtureEntity;
import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.repositories.general.analytics.MixtureRepository;
import com.example.ecommerceDemo.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MixtureService {

    private final MixtureRepository mixtureRepository;
    private final UserRepository userRepository;

    public MixtureService(MixtureRepository mixtureRepository, UserRepository userRepository) {
        this.mixtureRepository = mixtureRepository;
        this.userRepository = userRepository;
    }


    private UserEntity getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<Long> getMixtureIds(Long userId) {
        getUserById(userId);
        List<MixtureEntity> mixtures = mixtureRepository.findByUserUserId(userId);
        List<Long> mixtureIds = new ArrayList<>();
        for (MixtureEntity mixture : mixtures) {
            mixtureIds.add(mixture.getMixtureId());
        }
        return mixtureIds;
    }

    public List<Integer> getWeeklySales(Long userId) {
        getUserById(userId);
        List<MixtureEntity> mixtures = mixtureRepository.findByUserUserId(userId);
        List<Integer> weeklySales = new ArrayList<>();
        for (MixtureEntity mixture : mixtures) {
            weeklySales.add(mixture.getWeeklySales());
        }
        return weeklySales;
    }

    public List<Integer> getNewUsers(Long userId) {
        getUserById(userId);
        List<MixtureEntity> mixtures = mixtureRepository.findByUserUserId(userId);
        List<Integer> newUsers = new ArrayList<>();
        for (MixtureEntity mixture : mixtures) {
            newUsers.add(mixture.getNewUsers());
        }
        return newUsers;
    }

    public List<Integer> getItemOrders(Long userId) {
        getUserById(userId);
        List<MixtureEntity> mixtures = mixtureRepository.findByUserUserId(userId);
        List<Integer> itemOrders = new ArrayList<>();
        for (MixtureEntity mixture : mixtures) {
            itemOrders.add(mixture.getItemOrders());
        }
        return itemOrders;
    }

    public List<Integer> getBugReports(Long userId) {
        getUserById(userId);
        List<MixtureEntity> mixtures = mixtureRepository.findByUserUserId(userId);
        List<Integer> bugReports = new ArrayList<>();
        for (MixtureEntity mixture : mixtures) {
            bugReports.add(mixture.getBugReports());
        }
        return bugReports;
    }

}