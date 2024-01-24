package com.mate.onlinebookstore.onlinebookstore.service.user.impl;

import com.mate.onlinebookstore.onlinebookstore.dto.user.UserRegistrationRequestDto;
import com.mate.onlinebookstore.onlinebookstore.dto.user.UserResponseDto;
import com.mate.onlinebookstore.onlinebookstore.mapper.user.UserMapper;
import com.mate.onlinebookstore.onlinebookstore.repository.user.UserRepository;
import com.mate.onlinebookstore.onlinebookstore.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto) {
        return userMapper.toDto(userRepository.save(userMapper.toModel(requestDto)));
    }
}
