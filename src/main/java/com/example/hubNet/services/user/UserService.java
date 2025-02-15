package com.example.hubNet.services.user;

import com.example.hubNet.DTO.others.ProcessPaymentRequest;
import com.example.hubNet.DTO.user.UserDTO;
import com.example.hubNet.entities.user.PremiumAccount;
import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.entities.user.enums.UserStatus;
import com.example.hubNet.repositories.user.UserRepository;
import com.example.hubNet.services.mappers.user.UserMappers;
import com.example.hubNet.services.others.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PaymentService paymentService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PaymentService paymentService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.paymentService = paymentService;
        this.passwordEncoder = passwordEncoder;
    }




    @Transactional
    public UserDTO registerUser(UserDTO userDTO) {

        if (userRepository.findByEmailAddress(userDTO.getEmailAddress()).isPresent()) {
            throw new RuntimeException("User with this email already exists");
        }

        UserEntity user = new UserEntity();
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setEmailAddress(userDTO.getEmailAddress());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setUserStatus(UserStatus.ACTIVE);

        userRepository.save(user);

        return UserMappers.toDTO(user);
    }

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public UserDTO updateUser(Long userId, UserEntity updatedUser) {
        UserEntity user = userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("User not found"));

        user.setEmailAddress(updatedUser.getEmailAddress());
        user.setName(updatedUser.getName());
        user.setLastName(updatedUser.getLastName());
        user.setUserStatus(updatedUser.getUserStatus());


        userRepository.save(user);

        return UserMappers.toDTO(user);
    }

    @Transactional
    public UserDTO getUser(Long userId) {

        UserEntity user = new UserEntity();

        userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("User not found"));

        return UserMappers.toDTO(user);
    }

    @Transactional
    public List<UserDTO> getAllUsers() {
        List<UserEntity> entities = userRepository.findAll();
        List<UserDTO> dtoList = new ArrayList<>();
        for (UserEntity u : entities) {
            UserDTO userDTO = UserMappers.toDTO(u);

            dtoList.add(userDTO);
        }
        return dtoList;
    }

    @Transactional
    public void changePassword(Long userId,
                               String oldPassword,
                               String newPassword,
                               String confirmNewPassword) {
        UserEntity user = userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(oldPassword)) {
            throw new RuntimeException("Old password is incorrect");
        }
        if (newPassword == null || newPassword.isEmpty() || !newPassword.equals(confirmNewPassword)) {
            throw new RuntimeException("New passwords do not match or are invalid");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Transactional
    public void banUser(Long userId, Long bannedUserId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserEntity bannedUser = userRepository.findById(bannedUserId)
                .orElseThrow(() -> new RuntimeException("User to be banned not found"));
        user.getBannedUsers().add(bannedUser);
        user.setUserStatus(UserStatus.BANNED);
        userRepository.save(user);
    }

    @Transactional
    public void premiumAccount(Long userId, ProcessPaymentRequest paymentRequest) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        if (userEntity.getPremiumAccount() != null) {
            throw new RuntimeException("User is already a premium member.");
        }

        paymentRequest.getPaymentEntity().setPaymentAmount(BigDecimal.valueOf(15.00));

        paymentService.processPayment(userId, paymentRequest);

        LocalDateTime activationDate = LocalDateTime.now();
        LocalDateTime expirationDate = activationDate.plusMonths(1);
        activatePremiumAccount(userEntity, activationDate, expirationDate);

        userRepository.save(userEntity);
    }


    private void activatePremiumAccount(UserEntity userEntity, LocalDateTime activationDate, LocalDateTime expirationDate) {
        PremiumAccount premiumAccount = userEntity.getPremiumAccount();
        if (premiumAccount == null) {
            premiumAccount = new PremiumAccount();
            userEntity.setPremiumAccount(premiumAccount);
        }
        premiumAccount.setUser(userEntity);
        premiumAccount.setActivationDate(activationDate);
        premiumAccount.setExpirationDate(expirationDate);
    }


    public boolean isPremium(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        PremiumAccount premiumAccount = user.getPremiumAccount();
        return premiumAccount != null && premiumAccount.getExpirationDate().isAfter(LocalDateTime.now());
    }




}
