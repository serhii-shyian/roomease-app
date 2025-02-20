package com.example.roomease.dto.user;

import com.example.roomease.validation.Password;
import jakarta.validation.constraints.NotBlank;

public record UserLoginRequestDto(
        @NotBlank(message = "Username may not be blank")
        String username,
        @NotBlank(message = "Password may not be blank")
        @Password
        String password) {
}
