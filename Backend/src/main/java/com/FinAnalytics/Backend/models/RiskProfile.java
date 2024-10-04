package com.FinAnalytics.Backend.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.Date;

@Entity
@Table(name = "risk_profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "risk_profile_id")
    private UUID riskProfileId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "age_risk_score")
    private int ageRiskScore;

    @Column(name = "income_risk_score")
    private int incomeRiskScore;

    @Column(name = "investment_horizon_score")
    private int investmentHorizonScore;

    @Column(name = "reaction_to_loss_score")
    private int reactionToLossScore;

    @Column(name = "total_risk_score")
    private double totalRiskScore;

    @Column(name = "risk_level")
    private String riskLevel;

    @Column(name = "created_date")
    private Date createdDate;
}
