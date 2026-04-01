package com.MAJORPROJECT.LOVABLE.dto.project;

import com.MAJORPROJECT.LOVABLE.dto.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse( Long id,
                               String name,
                               Instant createdAt,
                               Instant updatedAt,
                               UserProfileResponse owner) {
}
