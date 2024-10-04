package com.FinAnalytics.Backend.repository;

import com.FinAnalytics.Backend.models.MarketData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MarketDataRepository extends JpaRepository<MarketData, Long> {
    List<MarketData> findByAssetType(String assetType);
}