package com.mate.onlinebookstore.onlinebookstore.service.user.impl;

import com.mate.onlinebookstore.onlinebookstore.dto.user.UserRegistrationRequestDto;
import com.mate.onlinebookstore.onlinebookstore.dto.user.UserResponseDto;
import com.mate.onlinebookstore.onlinebookstore.exception.RegistrationException;
import com.mate.onlinebookstore.onlinebookstore.mapper.user.UserMapper;
import com.mate.onlinebookstore.onlinebookstore.model.User;
import com.mate.onlinebookstore.onlinebookstore.repository.user.UserRepository;
import com.mate.onlinebookstore.onlinebookstore.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException {
        if (userRepository.findByEmail(requestDto.email()).isPresent()) {
            throw new RegistrationException("User with such email already registered!");
        }

        User user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    @Cacheable(value = "UserService::getById", key = "#id")
    public UserResponseDto getById(Long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("User with id %s does not exist", id))));
    }


}
