package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.entities.Question;
import com.upc.talkiabackend.services.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    private final ModelMapper modelMapper = new ModelMapper();


    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/questions")
    public ResponseEntity<?> listQuestions(){
        try {

            List<Question> list = questionService.listQuestions();
            List<QuestionDTO> listDTO = modelMapper.map(list, List.class);
            return new ResponseEntity<>(listDTO, HttpStatus.OK);

        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}