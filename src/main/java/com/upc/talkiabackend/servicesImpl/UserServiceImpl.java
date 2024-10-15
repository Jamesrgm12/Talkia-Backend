package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.entities.User;
import com.upc.talkiabackend.repositories.UserRepository;
import com.upc.talkiabackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
