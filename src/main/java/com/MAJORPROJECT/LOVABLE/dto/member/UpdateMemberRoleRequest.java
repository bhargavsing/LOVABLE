package com.MAJORPROJECT.LOVABLE.dto.member;

import com.MAJORPROJECT.LOVABLE.enums.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole role
) {
}
