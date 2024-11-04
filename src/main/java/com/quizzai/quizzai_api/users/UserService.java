package com.quizzai.quizzai_api.users;

import org.springframework.stereotype.Service;

import com.quizzai.quizzai_api.auth.RegisterRequestDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public Page<UserEntity> findAll(Long id, String name, String email, String country, Pageable pageable) {
        return userRepository.findByFilter(id, name, email, country, pageable);
    }

    public UserEntity createUser(RegisterRequestDTO user) {
        UserEntity u = UserEntity.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .country(user.getCountry())
                .totalPoints(0L)
                .quizCount(0L)
                .rightCount(0L)
                .build();
        return userRepository.save(u);
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
