package com.example.roomease.service.user;

import com.example.roomease.dto.user.UserRegisterRequestDto;
import com.example.roomease.dto.user.UserResponseDto;
import com.example.roomease.exception.RegistrationException;
import com.example.roomease.mapper.UserMapper;
import com.example.roomease.model.Role;
import com.example.roomease.model.User;
import com.example.roomease.repository.role.RoleRepository;
import com.example.roomease.repository.user.UserRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(UserRegisterRequestDto registrationDto)
            throws RegistrationException {
        if (userRepository.findByUsername(registrationDto.username()).isPresent()) {
            throw new RegistrationException(
                    String.format("User with username %s already exists",
                            registrationDto.username()));
        }

        User userFromDto = userMapper.toEntity(registrationDto);
        userFromDto.setPassword(passwordEncoder.encode(registrationDto.password()));
        userFromDto.setRoles(findByNameContaining(List.of(
                Role.RoleName.USER)));

        User savedUser = userRepository.save(userFromDto);

        return userMapper.toDto(savedUser);
    }

    private Set<Role> findByNameContaining(List<Role.RoleName> rolesList) {
        return new HashSet<>(roleRepository.findAllByNameContaining(rolesList));
    }
}
