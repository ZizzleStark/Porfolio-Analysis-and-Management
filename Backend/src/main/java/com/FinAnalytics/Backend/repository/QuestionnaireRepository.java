package com.FinAnalytics.Backend.repository;

import com.FinAnalytics.Backend.models.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
    List<Questionnaire> findByUserId(Long userId);
}
