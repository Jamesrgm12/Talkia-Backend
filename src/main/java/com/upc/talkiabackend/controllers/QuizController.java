package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.dtos.QuizDTO;
import com.upc.talkiabackend.entities.Quiz;
import com.upc.talkiabackend.services.QuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizController {
    @Autowired
    private QuizService quizService;

    ModelMapper modelMapper=new ModelMapper();

    @GetMapping("/quizzes")
    public List<QuizDTO> listQuizzes(){
        List<Quiz> quizzes =quizService.listQuizzes();
        List<QuizDTO> quizzesDTOs= modelMapper.map(quizzes,List.class);
        return quizzesDTOs;
    }

    @PostMapping("/quiz/{userId}")
    public Quiz insertQuiz(@PathVariable int userId){
        return quizService.insertQuiz(userId);
    }
}
