package com.example.hubNet.services.general;

import com.example.hubNet.entities.general.users.ActiveUsers;
import com.example.hubNet.repositories.general.users.ActiveUsersRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ActiveUsersService {

    private final ActiveUsersRepository activeUsersRepository;

    public ActiveUsersService(ActiveUsersRepository activeUsersRepository) {
        this.activeUsersRepository = activeUsersRepository;
    }

    public long countActiveUsers() {

        List<ActiveUsers> allUsers = activeUsersRepository.findAll();
        LocalDateTime now = LocalDateTime.now();
        long activeUserCount = 0;

        for (ActiveUsers user : allUsers) {
            if (user.getLastSeen() != null &&
                    ChronoUnit.MONTHS.between(user.getLastSeen(), now) < 3) {
                activeUserCount++;
            }
        }

        return activeUserCount;
    }
}
