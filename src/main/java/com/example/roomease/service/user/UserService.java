package com.example.roomease.service.user;

import com.example.roomease.dto.user.UserRegisterRequestDto;
import com.example.roomease.dto.user.UserResponseDto;
import com.example.roomease.exception.RegistrationException;
import com.example.roomease.model.User;
import java.util.List;

public interface UserService {
    UserResponseDto register(UserRegisterRequestDto registrationDto)
            throws RegistrationException;

    UserResponseDto updateUserRoles(Long userId, List<String> roleNames);

    UserResponseDto findProfile(User user);

    UserResponseDto updateProfile(User user, UserRegisterRequestDto updateDto);
}
