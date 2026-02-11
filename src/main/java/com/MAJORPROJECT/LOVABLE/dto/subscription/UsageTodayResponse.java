package com.MAJORPROJECT.LOVABLE.dto.subscription;


public record UsageTodayResponse(Integer tokensUsed,
                                 Integer tokensLimit,
                                 Integer previewsRunning,
                                 Integer previousLimit) {
}
