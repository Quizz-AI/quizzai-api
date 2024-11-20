package com.quizzai.quizzai_api.integration;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GoogleApiClient {
    private final WebClient webClient;
    private final ApiKeyConfig apiKeyConfig;

    public GoogleApiClient(WebClient.Builder webClientBuilder, ApiKeyConfig apiKeyConfig) {
        this.webClient = webClientBuilder
                .baseUrl("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash")
                .build();
        this.apiKeyConfig = apiKeyConfig;
    }

    public String googleApiCall(String text) {

        String body = apiCallBodyFormatter(text);

        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path(":generateContent")
                        .queryParam("key", apiKeyConfig.getApiKey()) // Adiciona a chave na requisição
                        .build())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private String apiCallBodyFormatter(String text) {
        return """
                {
                  "contents": [
                    {
                      "parts": [
                        {
                          "text": "%s"
                        }
                      ]
                    }
                  ]
                }
                """.formatted(text);
    }
}