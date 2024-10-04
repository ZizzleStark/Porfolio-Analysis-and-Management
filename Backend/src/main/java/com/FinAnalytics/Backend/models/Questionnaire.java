package com.FinAnalytics.Backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "questionnaires")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "questionnaire_id")
    private UUID questionnaireId;

    @Column(name = "user_id")
    private UUID userId;

    @ElementCollection
    @CollectionTable(name = "questions", joinColumns = @JoinColumn(name = "questionnaire_id"))
    @Column(name = "question")
    private List<String> questions;

    @ElementCollection
    @CollectionTable(name = "answers", joinColumns = @JoinColumn(name = "questionnaire_id"))
    @Column(name = "answer")
    private List<String> answers;

    @Column(name = "risk_score")
    private double riskScore;
}