package com.FinAnalytics.Backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


@Builder
@Entity
@Table(name = "investment_portfolios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private Long portfolioId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "grand_total")
    private double grandTotal;

    @Column(name = "statement_period_from")
    private String statementPeriodFrom;

    @Column(name = "statement_period_to")
    private String statementPeriodTo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "investmentPortfolio")
    private List<AccountInfo> accounts;

    @Column(name = "updated_date")
    private Date updatedDate;
}