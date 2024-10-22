package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.services.UserContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserContentController {

    @Autowired
    private UserContentService userContentService;

    @PostMapping("/user_content/{contentId}/{userId}")
    public ResponseEntity<?> InsertUserContent(@PathVariable(name = "contentId") Integer contentId,
                                               @PathVariable(name = "userId") Integer userId) {
        try {
            userContentService.insertUserContent(contentId, userId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
