package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.dtos.queries.ShowAnswersByQuestionUserDTO;
import com.upc.talkiabackend.services.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    private final ModelMapper modelMapper = new ModelMapper();

    //@PreAuthorize("hasRole('USER')")
    @GetMapping("/answers/listAnswersByQuestionUser/{questionId}")
    public ResponseEntity<?> listAnswerByQuestionUser(@PathVariable int questionId) {
        try {
            List<ShowAnswersByQuestionUserDTO> answersDTOs= answerService.listAnswerByQuestionUser(questionId);
            return new ResponseEntity<>(answersDTOs, HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
