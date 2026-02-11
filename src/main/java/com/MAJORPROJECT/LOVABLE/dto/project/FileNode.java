package com.MAJORPROJECT.LOVABLE.dto.project;

import java.time.Instant;

public record FileNode(
        String path,
        Long size,
        Instant modifiedAt,
        String type
) {
}
