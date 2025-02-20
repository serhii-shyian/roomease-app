package com.example.roomease.dto.user;

import java.util.Set;

public record UserResponseDto(
        Long id,
        String username,
        String email,
        String firstName,
        String lastName,
        Set<String> roles) {
}
