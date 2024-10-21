package com.FinAnalytics.Backend.service;

import com.FinAnalytics.Backend.models.AccountInfo;
import com.FinAnalytics.Backend.models.Equity;
import com.FinAnalytics.Backend.models.InvestmentPortfolio;
import com.FinAnalytics.Backend.models.MutualFund;
import com.FinAnalytics.Backend.repository.AccountInfoRepository;
import com.FinAnalytics.Backend.repository.EquityRepository;
import com.FinAnalytics.Backend.repository.InvestmentPortfolioRepository;
import com.FinAnalytics.Backend.repository.MutualFundRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InvestmentPortfolioSaveService {

    public void saveInvestmentPortfolio(String jsonResponse) throws Exception {
        JsonNode jsonNode = objectMapper.readTree(jsonResponse);

        // Create and save InvestmentPortfolio using Builder
        InvestmentPortfolio portfolio = new InvestmentPortfolio.Builder()
                .userId(jsonNode.get("user_id").asInt())
                .grandTotal(jsonNode.get("grand_total").asDouble())
                .statementPeriodFrom(jsonNode.get("statement_period_from").asText())
                .statementPeriodTo(jsonNode.get("statement_period_to").asText())
                .updatedDate(new Date())
                .build();

        InvestmentPortfolio savedPortfolio = investmentPortfolioRepository.save(portfolio);

        // Save AccountInfo using Builder
        for (JsonNode accountNode : jsonNode.get("accounts")) {
            AccountInfo accountInfo = new AccountInfo.Builder()
                    .investmentPortfolio(savedPortfolio)
                    .accountNumber(accountNode.get("account_number").asText())
                    .accountType(accountNode.get("account_type").asText()) // Example field
                    .balance(accountNode.get("balance").asDouble()) // Example field
                    // Add other fields from accountNode as necessary...
                    .build();
            accountInfoRepository.save(accountInfo);
        }

        // Save Equities using Builder
        for (JsonNode equityNode : jsonNode.get("equities")) {
            Equity equity = new Equity.Builder()
                    .accountInfo(accountInfo) // Ensure accountInfo is set appropriately
                    .stockName(equityNode.get("stock_name").asText())
                    .quantity(equityNode.get("quantity").asInt()) // Example field
                    .purchasePrice(equityNode.get("purchase_price").asDouble()) // Example field
                    // Add other fields from equityNode as necessary...
                    .build();
            equityRepository.save(equity);
        }

        // Save Mutual Funds using Builder
        for (JsonNode mutualFundNode : jsonNode.get("mutual_funds")) {
            MutualFund mutualFund = new MutualFund.Builder()
                    .accountInfo(accountInfo) // Ensure accountInfo is set appropriately
                    .fundName(mutualFundNode.get("fund_name").asText())
                    .units(mutualFundNode.get("units").asDouble()) // Example field
                    .investmentAmount(mutualFundNode.get("investment_amount").asDouble()) // Example field
                    // Add other fields from mutualFundNode as necessary...
                    .build();
            mutualFundRepository.save(mutualFund);
        }
    }
}