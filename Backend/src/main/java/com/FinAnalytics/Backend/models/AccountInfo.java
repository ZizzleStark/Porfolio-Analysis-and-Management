package com.FinAnalytics.Backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;


@Builder
@Entity
@Table(name = "account_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountStatus;
    private String boId;
    private String boStatus;
    private String dpName;
    private String emailId;
    private String nominee;
    private String mobileNo;


    @Column(name = "account_type")
    private String accountType;

    @Column(name = "value")
    private Double value;

    private Double totalEquity;

    @ManyToOne
    @JoinColumn(name = "portfolio_id") // This is the foreign key column
    private InvestmentPortfolio investmentPortfolio;

    @OneToMany(mappedBy = "accountInfo", cascade = CascadeType.ALL)
    private List<Equity> equities;
}