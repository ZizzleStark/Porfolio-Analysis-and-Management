package com.FinAnalytics.Backend.repository;

import com.FinAnalytics.Backend.models.MutualFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MutualFundRepository extends JpaRepository<MutualFund, Long> {
}