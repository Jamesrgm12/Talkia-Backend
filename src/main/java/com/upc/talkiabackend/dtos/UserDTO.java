package com.upc.talkiabackend.dtos;

import com.upc.talkiabackend.entities.Level;
import com.upc.talkiabackend.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private Integer id;
    private String userName;
    private String name;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private Double totalPoints;
    private Role role;
    private LocalDateTime iCreatedAt;
    private LocalDateTime iModifiedAt;
    private Level level;
}