package com.FinAnalytics.Backend.service.impl;

import com.FinAnalytics.Backend.models.Questionnaire;
import com.FinAnalytics.Backend.repository.QuestionnaireRepository;
import com.FinAnalytics.Backend.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Override
    public Questionnaire createQuestionnaire(Questionnaire questionnaire) {
        return questionnaireRepository.save(questionnaire);
    }

    @Override
    public Optional<Questionnaire> getQuestionnaireById(Long id) {
        return questionnaireRepository.findById(id);
    }

    @Override
    public Questionnaire updateQuestionnaire(Long id, Questionnaire questionnaireDetails) {
        Optional<Questionnaire> existingQuestionnaireOpt = getQuestionnaireById(id);
        if (existingQuestionnaireOpt.isPresent()) {
            Questionnaire existingQuestionnaire = existingQuestionnaireOpt.get();
            existingQuestionnaire.setQuestions(questionnaireDetails.getQuestions());
            return questionnaireRepository.save(existingQuestionnaire);
        } else {
            throw new IllegalArgumentException("Questionnaire with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteQuestionnaire(Long id) {
        questionnaireRepository.deleteById(id);
    }

    @Override
    public List<Questionnaire> getAllQuestionnaires() {
        return questionnaireRepository.findAll();
    }
}