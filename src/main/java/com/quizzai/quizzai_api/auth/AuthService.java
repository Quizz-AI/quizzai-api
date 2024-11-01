package com.quizzai.quizzai_api.auth;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String login() {
        return "login";
    }

    public String register() {
        return "register";
    }

    public String logout() {
        return "logout";
    }
}
