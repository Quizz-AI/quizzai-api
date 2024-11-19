package com.quizzai.quizzai_api.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quizzai.quizzai_api.config.security.TokenService;
import com.quizzai.quizzai_api.users.UserEntity;
import com.quizzai.quizzai_api.users.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final TokenService tokenService;

    public AuthRespondeDTO login(LoginRequestDTO userDTO) {
        UserEntity user = userService.findByEmail(userDTO.getEmail());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        if (userDTO.getPassword() == null || !userDTO.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password: " + user.getPassword() + " - " + userDTO.getPassword());
        }
        String token = tokenService.generateToken(user);
        return AuthRespondeDTO.builder().token(token).build();
    }

    public AuthRespondeDTO register(RegisterRequestDTO userDTO) {
        UserEntity user = userService.findByEmail(userDTO.getEmail());
        if (user != null) {
            throw new RuntimeException("User already exists");
        }
        user = userService.createUser(userDTO);
        String token = tokenService.generateToken(user);
        return AuthRespondeDTO.builder().token(token).build();
    }

}
