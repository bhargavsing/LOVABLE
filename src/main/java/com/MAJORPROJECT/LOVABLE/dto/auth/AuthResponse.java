package com.MAJORPROJECT.LOVABLE.dto.auth;
//jwt auth ->token
public record AuthResponse(String token,UserProfileResponse user) {
}
