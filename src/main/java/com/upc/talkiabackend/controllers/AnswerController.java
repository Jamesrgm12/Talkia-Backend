package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.dtos.AnswerDTO;
import com.upc.talkiabackend.dtos.queries.ShowAnswersByQuestionAdminDTO;
import com.upc.talkiabackend.dtos.queries.ShowAnswersByQuestionUserDTO;
import com.upc.talkiabackend.entities.Answer;
import com.upc.talkiabackend.services.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    private final ModelMapper modelMapper = new ModelMapper();

    @PreAuthorize("hasRole('USER')")
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
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/answer")
    public ResponseEntity<?> insertAnswer(@RequestBody AnswerDTO answerDTO){
        try {
            Answer answer = modelMapper.map(answerDTO, Answer.class);
            answer = answerService.insertAnswer(answer);
            answerDTO = modelMapper.map(answer,AnswerDTO.class);
            return new ResponseEntity<>(answerDTO, HttpStatus.CREATED);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/answers/listAnswersByQuestionAdmin/{questionId}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ShowAnswersByQuestionAdminDTO> listAnswerByQuestionAdmin(@PathVariable int questionId) {
        return answerService.listAnswerByQuestionAdmin(questionId);
    }
}
