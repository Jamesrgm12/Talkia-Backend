package com.upc.talkiabackend.services;

import com.upc.talkiabackend.entities.User;

import java.util.List;

public interface UserService {
    public void updateLevelUser(int userId);
    public User insertUser(User user);
    public List<User> listUsers();

}
