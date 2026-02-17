package com.MAJORPROJECT.LOVABLE.services.impl;

import com.MAJORPROJECT.LOVABLE.dto.subscription.CheckOutResponse;
import com.MAJORPROJECT.LOVABLE.dto.subscription.CheckoutRequest;
import com.MAJORPROJECT.LOVABLE.dto.subscription.PortalResponse;
import com.MAJORPROJECT.LOVABLE.dto.subscription.SubscriptionResponse;
import com.MAJORPROJECT.LOVABLE.services.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckOutResponse createCheckoutSession(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
