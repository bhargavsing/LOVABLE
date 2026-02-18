package com.MAJORPROJECT.LOVABLE.entity;

import com.MAJORPROJECT.LOVABLE.enums.SubscriptionStatus;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription {
    Long id;

    User user;

    Plan planId;

    String stripeSubscriptionId;

    SubscriptionStatus status;//ACTIVE,CANCELLED,INCOMPLETED,PAST_DUE

    Instant currentPeriodStart;
    Instant currentPeriodEnd;
    Instant createdAt;
    Instant updatedAt;
}
