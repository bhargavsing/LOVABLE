package com.MAJORPROJECT.LOVABLE.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatSession {
    User user;
    Project project;

    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;

    String title;
}
