//package com.example.ecommerceDemo.services.blog;
//
//import com.example.ecommerceDemo.entities.blog.CountEntity;
//import com.example.ecommerceDemo.repositories.blog.CountRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Service
//public class CountService {
//
//    private final CountRepository countRepository;
//
//    private final ConcurrentHashMap<String, Set<String>> endpointUserMap = new ConcurrentHashMap<>();
//
//    public CountService(CountRepository countRepository) {
//        this.countRepository = countRepository;
//    }
//
//    public void record(String endpoint, String userId) {
//        endpointUserMap.putIfAbsent(endpoint, ConcurrentHashMap.newKeySet());
//        Set<String> users = endpointUserMap.get(endpoint);
//        users.add(userId);
//
//        CountEntity count = countRepository.findByEndpoint(endpoint)
//                .orElse(new CountEntity());
//
//        count.setEndpoint(endpoint);
//        count.setUniqueUserCount(users.size());
//
//        countRepository.save(count);
//    }
//
//
//}
