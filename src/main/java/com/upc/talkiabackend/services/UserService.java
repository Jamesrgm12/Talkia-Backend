package com.upc.talkiabackend.services;

import com.upc.talkiabackend.entities.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    public void updateLevelUser(int userId);
    public User insertUser(User user);
    public List<User> listUsers();
    public List<User> listUsersByRegisterDate(LocalDate startDate, LocalDate endDate);
    public List<User> listUsersByStatus(String status);
    public User updateUser(User user);
}
