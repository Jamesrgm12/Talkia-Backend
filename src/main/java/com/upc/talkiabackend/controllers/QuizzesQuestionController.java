package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.services.QuizzesQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuizzesQuestionController {
    @Autowired
    private QuizzesQuestionService qqService;
    @PutMapping("/quizzesQuestion/answerQuestion/{qqId}/{userAnswer}")
    public String answerQuestion(@PathVariable int qqId, @PathVariable String userAnswer){
        return qqService.answerQuestion(qqId, userAnswer);
    }
}
