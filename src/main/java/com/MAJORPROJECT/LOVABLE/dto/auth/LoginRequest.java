package com.MAJORPROJECT.LOVABLE.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
