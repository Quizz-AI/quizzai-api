package com.quizzai.quizzai_api.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyConfig {

    @Value("${google.api.key}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
