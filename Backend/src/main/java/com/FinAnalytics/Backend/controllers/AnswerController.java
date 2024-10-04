package com.FinAnalytics.Backend.controllers;

import com.FinAnalytics.Backend.models.Answer;
import com.FinAnalytics.Backend.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    // Endpoint to create a new answer
    @PostMapping
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {
        try {
            Answer createdAnswer = answerService.createAnswer(answer);
            return new ResponseEntity<>(createdAnswer, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint to get answers for a questionnaire and user
    @GetMapping("/questionnaire/{questionnaireId}/user/{userId}")
    public ResponseEntity<List<Answer>> getAnswersByQuestionnaireAndUser(@PathVariable Long questionnaireId, @PathVariable Long userId) {
        List<Answer> answers = answerService.getAnswersByQuestionnaireAndUser(questionnaireId, userId);
        if (answers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }
}