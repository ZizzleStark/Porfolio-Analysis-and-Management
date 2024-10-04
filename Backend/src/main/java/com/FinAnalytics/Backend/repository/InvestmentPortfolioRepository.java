package com.FinAnalytics.Backend.repository;



import com.FinAnalytics.Backend.models.InvestmentPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InvestmentPortfolioRepository extends JpaRepository<InvestmentPortfolio, Long> {
    List<InvestmentPortfolio> findByUserId(Long userId);
}
