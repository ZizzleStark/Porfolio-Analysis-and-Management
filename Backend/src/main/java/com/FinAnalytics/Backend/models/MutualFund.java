package com.FinAnalytics.Backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.springframework.retry.annotation.Backoff;


@Builder
@Entity
@Table(name = "mutual_funds")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MutualFund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "folio_number")
    private String folioNumber;

    @Column(name = "fund_name")
    private String fundName;

    @Column(name = "investment_amount")
    private Double investmentAmount;

    @Column(name = "current_value")
    private Double currentValue;
}