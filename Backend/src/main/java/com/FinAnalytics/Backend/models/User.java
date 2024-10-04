package com.FinAnalytics.Backend.models;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "income")
    private double income;

    @Column(name = "savings_percentage")
    private double savingsPercentage;

    @Column(name = "dependants")
    private int dependants;

    @Column(name = "debt")
    private double debt;

    @Column(name = "emergency_fund")
    private double emergencyFund;

    @Column(name = "investment_horizon")
    private int investmentHorizon;

    @Column(name = "reaction_to_loss")
    private String reactionToLoss;

    @Column(name = "risk_appetite")
    private double riskAppetite;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;
}