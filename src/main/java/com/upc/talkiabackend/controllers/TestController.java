package com.upc.talkiabackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
    @GetMapping("/user")
    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String userEndpoint() {
        return "Bienvenido a talkia estimado estudiante";
    }

}
