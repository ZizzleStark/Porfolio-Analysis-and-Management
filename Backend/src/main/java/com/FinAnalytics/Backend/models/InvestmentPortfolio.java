package com.FinAnalytics.Backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "investment_portfolios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "portfolio_id")
    private UUID portfolioId;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "stocks_percentage")
    private double stocksPercentage;

    @Column(name = "bonds_percentage")
    private double bondsPercentage;

    @Column(name = "other_assets_percentage")
    private double otherAssetsPercentage;

    @Column(name = "portfolio_value")
    private double portfolioValue;

    @Column(name = "risk_level")
    private String riskLevel;

    @Column(name = "updated_date")
    private Date updatedDate;
}
