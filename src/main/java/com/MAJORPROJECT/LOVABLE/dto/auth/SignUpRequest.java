package com.MAJORPROJECT.LOVABLE.dto.auth;

public record SignUpRequest(
        String email,
        String name,
        String password
) {
}
