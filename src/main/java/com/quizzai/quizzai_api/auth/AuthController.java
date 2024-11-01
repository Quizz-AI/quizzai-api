package com.quizzai.quizzai_api.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {

    @PostMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("logout")
    public String logout() {
        return "logout";
    }
}
