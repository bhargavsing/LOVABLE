package com.MAJORPROJECT.LOVABLE.dto.member;

import com.MAJORPROJECT.LOVABLE.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String name,
        String email,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
) {
}
