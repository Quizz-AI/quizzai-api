package com.quizzai.quizzai_api.config.environment;

import io.github.cdimascio.dotenv.Dotenv;

public class DotenvInitializer {

    public static void load() {
        Dotenv dotenv = Dotenv.load(); // Carrega o arquivo .env
        System.setProperty("google.api.key", dotenv.get("GOOGLE_API_KEY"));
    }
}
