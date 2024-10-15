package com.upc.talkiabackend.services;

import com.upc.talkiabackend.entities.User;

public interface UserService {
    public void updateLevelUser(int userId);
    public User insertUser(User user);

}
