// RiskProfileServiceImpl.java

package com.FinAnalytics.Backend.service.impl;

import com.FinAnalytics.Backend.models.RiskProfile;
import com.FinAnalytics.Backend.models.User;
import com.FinAnalytics.Backend.repository.RiskProfileRepository;
import com.FinAnalytics.Backend.repository.UserRepository;
import com.FinAnalytics.Backend.service.RiskProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RiskProfileServiceImpl implements RiskProfileService {

    @Autowired
    private RiskProfileRepository riskProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public RiskProfile calculateRiskProfile(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (!userOpt.isPresent()) {
            throw new RuntimeException("User not found");
        }
        User user = userOpt.get();


        double riskScore = 0;



        // Age factor (15% weight)
        if (user.getAge() < 30) {
            riskScore += 15;
        } else if (user.getAge() <= 50) {
            riskScore += 10;
        } else {
            riskScore += 5;
        }

        // Income factor (15% weight)
        if (user.getIncome() < 500000) {
            riskScore += 5;
        } else if (user.getIncome() <= 1000000) {
            riskScore += 10;
        } else {
            riskScore += 15;
        }

        // Savings percentage factor (10% weight)
        double savingsPercentage = user.getSavingsPercentage();
        if (savingsPercentage < 10) {
            riskScore += 3;
        } else if (savingsPercentage <= 30) {
            riskScore += 6;
        } else {
            riskScore += 10;
        }

        // Debt factor (10% weight)
        if (user.getDebt() > 500000) {
            riskScore += 3;
        } else if (user.getDebt() <= 500000) {
            riskScore += 7;
        }

        // Emergency fund factor (10% weight)
        if (user.getEmergencyFund() > 6 * user.getIncome()) {
            riskScore += 10;
        } else if (user.getEmergencyFund() >= 3 * user.getIncome()) {
            riskScore += 7;
        } else {
            riskScore += 3;
        }

        // Investment horizon factor (20% weight)
        if (user.getInvestmentHorizon() > 10) {
            riskScore += 20;
        } else if (user.getInvestmentHorizon() >= 3) {
            riskScore += 10;
        } else {
            riskScore += 5;
        }

        // Reaction to loss factor (10% weight)
        switch (user.getReactionToLoss()) {
            case "Sell all":
                riskScore += 3;
                break;
            case "Hold":
                riskScore += 7;
                break;
            case "Buy more":
                riskScore += 10;
                break;
        }

        // Risk appetite (10% weight)
        double riskAppetite = user.getRiskAppetite();
        if (riskAppetite < 500000) {
            riskScore += 3;
        } else if (riskAppetite <= 1000000) {
            riskScore += 7;
        } else {
            riskScore += 10;
        }




        String riskLevel;
        if (riskScore < 30) {
            riskLevel = "Low";
        } else if (riskScore < 70) {
            riskLevel = "Medium";
        } else {
            riskLevel = "High";
        }

        // Create and save the RiskProfile entity
        RiskProfile riskProfile = new RiskProfile();
        riskProfile.setUser(user);
        riskProfile.setAgeRiskScore((int)(riskScore / 15 * 100));
        riskProfile.setIncomeRiskScore((int)(riskScore / 15 * 100));
        riskProfile.setInvestmentHorizonScore((int)(riskScore / 20 * 100));
        riskProfile.setReactionToLossScore((int)(riskScore / 10 * 100));
        riskProfile.setTotalRiskScore(riskScore);
        riskProfile.setRiskLevel(riskLevel);

        return riskProfileRepository.save(riskProfile);
    }

    @Override
    public Optional<RiskProfile> getRiskProfileByUserId(Long userId) {
        return riskProfileRepository.findByUserId(userId);
    }
}
