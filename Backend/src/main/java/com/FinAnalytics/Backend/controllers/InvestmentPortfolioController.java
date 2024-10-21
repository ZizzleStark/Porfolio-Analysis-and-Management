package com.FinAnalytics.Backend.controllers;

import com.FinAnalytics.Backend.service.InvestmentPortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/investment")
public class InvestmentPortfolioController {

    private final InvestmentPortfolioService investmentPortfolioService;

    public InvestmentPortfolioController(InvestmentPortfolioService investmentPortfolioService) {
        this.investmentPortfolioService = investmentPortfolioService;
    }

    @PostMapping("/upload")
    public Mono<ResponseEntity<String>> uploadPortfolio(
            @RequestParam("file") MultipartFile file,
            @RequestParam("password") String password) {

        try {
            return investmentPortfolioService.uploadPdfWithPassword(file, password)
                    .map(response -> ResponseEntity.ok(response))
                    .onErrorResume(error -> Mono.just(ResponseEntity.badRequest().body(error.getMessage())));
        } catch (Exception e) {
            return Mono.just(ResponseEntity.badRequest().body("Failed to upload: " + e.getMessage()));
        }
    }
}