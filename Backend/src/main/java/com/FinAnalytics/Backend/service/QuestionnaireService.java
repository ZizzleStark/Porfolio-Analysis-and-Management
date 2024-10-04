package com.FinAnalytics.Backend.service;

import com.FinAnalytics.Backend.models.Questionnaire;

import java.util.Optional;
import java.util.List;

public interface QuestionnaireService {

    Questionnaire createQuestionnaire(Questionnaire questionnaire);

    Optional<Questionnaire> getQuestionnaireById(Long id);

    Questionnaire updateQuestionnaire(Long id, Questionnaire questionnaireDetails);

    void deleteQuestionnaire(Long id);

    List<Questionnaire> getAllQuestionnaires();
}