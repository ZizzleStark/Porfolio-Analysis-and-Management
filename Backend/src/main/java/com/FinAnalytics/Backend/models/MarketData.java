package com.FinAnalytics.Backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "market_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "market_data_id")
    private Long marketDataId;

    @Column(name = "asset_type")
    private String assetType;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "price")
    private double price;

    @Column(name = "price_change")
    private double priceChange;

    @Column(name = "risk_rating")
    private String riskRating;

    @Column(name = "date")
    private Date date;
}
