package com.FinAnalytics.Backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Builder
@Entity
@Table(name = "equities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isIn;
    private String isInName;
    private Double value;
    private Integer currentBalance;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountInfo accountInfo;


}