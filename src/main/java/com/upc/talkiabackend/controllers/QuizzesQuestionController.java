package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.services.QuizzesQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class QuizzesQuestionController {
    @Autowired
    private QuizzesQuestionService qqService;
    @PutMapping("/quizzesQuestion/answerQuestion/{qqId}/{userAnswer}")
    @PreAuthorize("hasRole('USER')")
    public String answerQuestion(@PathVariable int qqId, @PathVariable String userAnswer){
        return qqService.answerQuestion(qqId, userAnswer);
    }
    @GetMapping("quizzesQuestion/getAveragePointsByUser/{userId}")
    public ResponseEntity<?> getAveragePoints(@PathVariable int userId) {
        try {
            Double averagePoints = qqService.getAveragePoints(userId);
            return new ResponseEntity<>(averagePoints, HttpStatus.OK);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("quizzesQuestion/listTotalQuizzesCompleted/{userId}")
    public ResponseEntity<?> getTotalQuizzesCompleted(@PathVariable int userId) {
        try {
            Long totalQuizzesCompleted = qqService.getTotalQuizzesCompleted(userId);
            return new ResponseEntity<>(totalQuizzesCompleted, HttpStatus.OK);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //@PreAuthorize("hasRole('USER')")
    @GetMapping("quizzesQuestion/getAvgCorrectAnswers/{userId}")
    public ResponseEntity<?> getAverageCorrectAnswers(@PathVariable int userId){
        try {
            Double averageCorrectAnswers = qqService.getAverageCorrectAnswers(userId);
            return new ResponseEntity<>(averageCorrectAnswers, HttpStatus.OK);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
