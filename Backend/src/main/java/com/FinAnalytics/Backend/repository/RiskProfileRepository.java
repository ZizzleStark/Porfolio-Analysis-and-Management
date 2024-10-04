package com.FinAnalytics.Backend.repository;


import com.FinAnalytics.Backend.models.RiskProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RiskProfileRepository extends JpaRepository<RiskProfile, Long> {
    Optional<RiskProfile> findByUserId(Long userId);
}

