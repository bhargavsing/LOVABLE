package com.MAJORPROJECT.LOVABLE.services;

import com.MAJORPROJECT.LOVABLE.dto.subscription.PlanLimitsResponse;
import com.MAJORPROJECT.LOVABLE.dto.subscription.UsageTodayResponse;
import org.jspecify.annotations.Nullable;

public interface UsageService {
   UsageTodayResponse getTodayUsage(Long userId);
   PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
