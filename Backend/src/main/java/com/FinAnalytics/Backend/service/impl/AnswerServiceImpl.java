package com.FinAnalytics.Backend.service.impl;

import com.FinAnalytics.Backend.models.Answer;
import com.FinAnalytics.Backend.repository.AnswerRepository;
import com.FinAnalytics.Backend.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public List<Answer> getAnswersByQuestionnaireAndUser(Long questionnaireId, Long userId) {
        return answerRepository.findByQuestionnaire_IdAndUserId(questionnaireId, userId);
    }
}