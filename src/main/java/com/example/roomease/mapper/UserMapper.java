package com.example.roomease.mapper;

import com.example.roomease.config.MapperConfig;
import com.example.roomease.dto.user.UserRegisterRequestDto;
import com.example.roomease.dto.user.UserResponseDto;
import com.example.roomease.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);

    User toEntity(UserRegisterRequestDto registrationDto);
}
