package com.FinAnalytics.Backend.repository;

import com.FinAnalytics.Backend.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionnaire_IdAndUserId(Long questionnaireId, Long userId);
}