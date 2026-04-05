package com.MAJORPROJECT.LOVABLE.dto.member;

import com.MAJORPROJECT.LOVABLE.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String name,
        String username,
        ProjectRole projectRole,
        Instant invitedAt
) {
}
