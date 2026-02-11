package com.MAJORPROJECT.LOVABLE.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {
    Long id;

    String name;

    String StripePrideId;

    Integer maxProjects;
    Integer maxTokensPerDay;
    Integer maxPreviews;

    Boolean unlimitedai;

    Boolean active;
}
