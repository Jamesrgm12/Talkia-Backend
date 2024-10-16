package com.upc.talkiabackend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/user")
    public String userEndpoint() {
        return "Bienvenido a talkia estimado estudiante";
    }


    @GetMapping("/admin")
    //@PreAuthorize("hasRole('ADMIN')")
    public String adminEndpoint() {
        return "Bienvenido a talkia estimado administrador";
    }


}
