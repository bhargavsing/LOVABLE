package com.MAJORPROJECT.LOVABLE.services.impl;

import com.MAJORPROJECT.LOVABLE.dto.auth.AuthResponse;
import com.MAJORPROJECT.LOVABLE.dto.auth.LoginRequest;
import com.MAJORPROJECT.LOVABLE.dto.auth.SignUpRequest;
import com.MAJORPROJECT.LOVABLE.entity.User;
import com.MAJORPROJECT.LOVABLE.error.BadRequestException;
import com.MAJORPROJECT.LOVABLE.mapper.UserMapper;
import com.MAJORPROJECT.LOVABLE.repository.UserRepository;
import com.MAJORPROJECT.LOVABLE.services.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {
    PasswordEncoder passwordEncoder;
    UserMapper userMapper;
    UserRepository userRepository;
    @Override
    public AuthResponse signup(SignUpRequest request) {

        userRepository.findByUsername(request.username())
                .ifPresent(user -> {throw new
                        BadRequestException("user already exists with username"+request.username());
                });

        User user =userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);
        return new AuthResponse("dummy",userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
