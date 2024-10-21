package com.FinAnalytics.Backend.repository;

import com.FinAnalytics.Backend.models.Equity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquityRepository extends JpaRepository<Equity, Long> {

}