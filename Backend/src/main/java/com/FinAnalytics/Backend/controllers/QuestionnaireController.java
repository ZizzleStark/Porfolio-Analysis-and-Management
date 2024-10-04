package com.FinAnalytics.Backend.controllers;

import com.FinAnalytics.Backend.models.Questionnaire;
import com.FinAnalytics.Backend.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questionnaires")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @PostMapping("/create")
    public ResponseEntity<Questionnaire> createQuestionnaire(@RequestBody Questionnaire questionnaire) {
        Questionnaire createdQuestionnaire = questionnaireService.createQuestionnaire(questionnaire);
        return ResponseEntity.ok(createdQuestionnaire);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questionnaire> getQuestionnaireById(@PathVariable Long id) {
        return questionnaireService.getQuestionnaireById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Questionnaire>> getAllQuestionnaires() {
        return ResponseEntity.ok(questionnaireService.getAllQuestionnaires());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Questionnaire> updateQuestionnaire(@PathVariable Long id, @RequestBody Questionnaire questionnaireDetails) {
        try {
            Questionnaire updatedQuestionnaire = questionnaireService.updateQuestionnaire(id, questionnaireDetails);
            return ResponseEntity.ok(updatedQuestionnaire);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}