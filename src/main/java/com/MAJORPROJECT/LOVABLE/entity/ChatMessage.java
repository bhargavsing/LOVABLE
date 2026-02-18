package com.MAJORPROJECT.LOVABLE.entity;

import com.MAJORPROJECT.LOVABLE.enums.MessageRole;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    Long id;

    ChatSession chatSession;

    String content;
    String toolCalls;

    Integer tokensUsed;
    Instant createdAt;

    MessageRole role;

}
