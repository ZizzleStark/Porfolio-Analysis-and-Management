package com.FinAnalytics.Backend.repository;

import com.FinAnalytics.Backend.models.RiskProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface RiskProfileRepository extends JpaRepository<RiskProfile, Long> {

    @Query("SELECT rp FROM RiskProfile rp WHERE rp.user.userId = :userId")
    Optional<RiskProfile> findByUserId(@Param("userId") Long userId);
}