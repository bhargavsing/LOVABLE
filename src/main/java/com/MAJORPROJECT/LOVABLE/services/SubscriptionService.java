package com.MAJORPROJECT.LOVABLE.services;

import com.MAJORPROJECT.LOVABLE.dto.subscription.CheckOutResponse;
import com.MAJORPROJECT.LOVABLE.dto.subscription.CheckoutRequest;
import com.MAJORPROJECT.LOVABLE.dto.subscription.PortalResponse;
import com.MAJORPROJECT.LOVABLE.dto.subscription.SubscriptionResponse;
import org.jspecify.annotations.Nullable;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckOutResponse createCheckoutSession(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
