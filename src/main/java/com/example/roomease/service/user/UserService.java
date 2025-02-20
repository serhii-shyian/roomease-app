package com.example.roomease.service.user;

import com.example.roomease.dto.user.UserRegisterRequestDto;
import com.example.roomease.dto.user.UserResponseDto;
import com.example.roomease.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegisterRequestDto registrationDto)
            throws RegistrationException;
}
