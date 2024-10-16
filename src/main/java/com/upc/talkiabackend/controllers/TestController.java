package com.upc.talkiabackend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/user")
    public String userEndpoint() {
        return "Bienvenido a talkia estimado estudiante";
    }

}
