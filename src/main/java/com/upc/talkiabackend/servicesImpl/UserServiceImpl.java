package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.entities.User;
import com.upc.talkiabackend.repositories.UserRepository;
import com.upc.talkiabackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void updateLevelUser(int userId) {

    }

    @Override
    @Transactional
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> listUsersByRegisterDate(LocalDate startDate, LocalDate endDate){
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atStartOfDay();

        return userRepository.listUsersByRegisterDate(startDateTime, endDateTime);
    }
    @Override
    public List<User> listUsersByStatus(String status){
        return userRepository.listUsersByStatus(status);
    }


}
