package com.FinAnalytics.Backend.service;

import com.FinAnalytics.Backend.models.Answer;

import java.util.List;

public interface AnswerService {
    Answer createAnswer(Answer answer);
    List<Answer> getAnswersByQuestionnaireAndUser(Long questionnaireId, Long userId);
}