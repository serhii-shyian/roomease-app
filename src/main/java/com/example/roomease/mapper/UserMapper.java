package com.example.roomease.mapper;

import com.example.roomease.config.MapperConfig;
import com.example.roomease.dto.user.UserRegisterRequestDto;
import com.example.roomease.dto.user.UserResponseDto;
import com.example.roomease.model.Role;
import com.example.roomease.model.User;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    @Mapping(target = "roles", source = "roles", qualifiedByName = "rolesToStringSet")
    UserResponseDto toDto(User user);

    User toEntity(UserRegisterRequestDto registrationDto);

    void updateEntityFromDto(@MappingTarget User user, UserRegisterRequestDto updateDto);

    @Named("rolesToStringSet")
    default Set<String> mapRolesToStrings(Set<Role> roles) {
        return roles.stream()
                .map(role -> role.getName().name())
                .collect(Collectors.toSet());
    }
}
