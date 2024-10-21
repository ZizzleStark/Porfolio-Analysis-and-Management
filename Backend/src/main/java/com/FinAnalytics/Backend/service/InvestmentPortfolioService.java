package com.FinAnalytics.Backend.service;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class InvestmentPortfolioService {

    private final WebClient webClient;

    public InvestmentPortfolioService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://cas-parser-cams-amp-karvy-pdf-statements.p.rapidapi.com")
                .defaultHeader("b05bd34a15msh110274ea940e3e1p17da44jsn78340a27493e", "b05bd34a15msh110274ea940e3e1p17da44jsn78340a27493e")
                .defaultHeader("cas-parser-cams-amp-karvy-pdf-statements.p.rapidapi.com", "cas-parser-cams-amp-karvy-pdf-statements.p.rapidapi.com")
                .build();
    }

    public Mono<String> uploadPdfWithPassword(MultipartFile pdfFile, String password) throws Exception {
        String boundary = "----011000010111000001101001";

        return webClient.post()
                .uri("/auto_detect_cas/parse")
                .contentType(MediaType.parseMediaType("multipart/form-data; boundary=" + boundary))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE)
                .bodyValue(createMultipartBody(pdfFile, password, boundary))
                .retrieve()
                .bodyToMono(String.class);
    }

    private String createMultipartBody(MultipartFile pdfFile, String password, String boundary) throws Exception {
        StringBuilder body = new StringBuilder();
        body.append("--").append(boundary).append("\r\n");
        body.append("Content-Disposition: form-data; name=\"pdf_file\"; filename=\"")
                .append(pdfFile.getOriginalFilename()).append("\"\r\n");
        body.append("Content-Type: application/pdf\r\n\r\n");
        body.append(Base64.getEncoder().encodeToString(pdfFile.getBytes())).append("\r\n");

        body.append("--").append(boundary).append("\r\n");
        body.append("Content-Disposition: form-data; name=\"password\"\r\n\r\n");
        body.append(password).append("\r\n");

        body.append("--").append(boundary).append("--\r\n");

        return body.toString();
    }
}


