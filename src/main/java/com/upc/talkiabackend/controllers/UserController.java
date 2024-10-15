package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.dtos.UserDTO;
import com.upc.talkiabackend.entities.User;
import com.upc.talkiabackend.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper = new ModelMapper();

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping("/user")
    public ResponseEntity<?> insertUser(@RequestBody UserDTO userDTO){
        try {
            User user = modelMapper.map(userDTO, User.class);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user = userService.insertUser(user);
            userDTO = modelMapper.map(user, UserDTO.class);
            return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
