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

        // Use a chave de configuração para log ou setup, se necessário
        this.apiKeyConfig = apiKeyConfig;
    }

    public String gerarConteudo() {
        RequestGoogleDTO request = new RequestGoogleDTO();

        // Content content = new Content();
        // Part part = new Part();
        // part.setText("Escreva uma piada sobre meu amigo Gabriel");

        // content.setParts(List.of(part));
        // request.setContents(List.of(content));

        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path(":generateContent")
                        .queryParam("key", apiKeyConfig.getApiKey()) // Adiciona a chave na requisição
                        .build())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}