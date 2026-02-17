package com.MAJORPROJECT.LOVABLE.services.impl;

import com.MAJORPROJECT.LOVABLE.dto.auth.AuthResponse;
import com.MAJORPROJECT.LOVABLE.dto.auth.LoginRequest;
import com.MAJORPROJECT.LOVABLE.dto.auth.SignUpRequest;
import com.MAJORPROJECT.LOVABLE.services.AuthService;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignUpRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
