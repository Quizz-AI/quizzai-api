package com.quizzai.quizzai_api.users;

import org.springframework.web.bind.annotation.RestController;

import com.quizzai.quizzai_api.auth.RegisterRequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/users")
@Tag(name = "Users")
public class UserController {

    private final UserService userService;

    @GetMapping()
    @Operation(summary = "Get all users")
    public Page<UserEntity> getAllUsers(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String country,
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return this.userService.findAll(id, name, email, country, pageable);
    }

}
