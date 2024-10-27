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
    @Transactional
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateLevelUser(int userId) {

    }

    @Override
    @Transactional
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null;
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
    @Override
    public  List<User> getUserByUserNameContains(String username){
        return userRepository.getUserByUserNameContains(username);
    }


}
