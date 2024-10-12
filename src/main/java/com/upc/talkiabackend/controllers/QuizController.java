package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.dtos.QuizDTO;
import com.upc.talkiabackend.entities.Quiz;
import com.upc.talkiabackend.services.QuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizController {

    @Autowired
    private QuizService quizService;

    private final ModelMapper modelMapper=new ModelMapper();

    @GetMapping("/quizzes")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<QuizDTO> listQuizzes(){
        List<Quiz> quizzes =quizService.listQuizzes();
        List<QuizDTO> quizzesDTOs= modelMapper.map(quizzes,List.class);
        return quizzesDTOs;
    }

    @PostMapping("/quiz/{userId}")
    @PreAuthorize("hasRole('USER')")
    public Quiz insertQuiz(@PathVariable int userId){
        return quizService.insertQuiz(userId);
    }

    @GetMapping("/quizzes/{userId}")
    public ResponseEntity<?> listQuizzesByUserId(@PathVariable int userId) {
        try {
            List<Quiz> quizzes = quizService.listQuizzesByUserId(userId);
            List<QuizDTO> quizzDTOs= modelMapper.map(quizzes,List.class);
            return new ResponseEntity<>(quizzDTOs, HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
