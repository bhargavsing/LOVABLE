package com.MAJORPROJECT.LOVABLE.dto.subscription;

public record PlanResponse(Long id,
                           String name,
                           String price,
                           Integer maxTokensPerDay,
                           Boolean unlimitedAi,
                           Integer maxProjects) {
}
