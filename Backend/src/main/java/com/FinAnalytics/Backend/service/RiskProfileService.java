package com.FinAnalytics.Backend.service;

import com.FinAnalytics.Backend.models.RiskProfile;
import java.util.Optional;

public interface RiskProfileService {
    RiskProfile calculateRiskProfile(Long userId);
    Optional<RiskProfile> getRiskProfileByUserId(Long userId);

}
