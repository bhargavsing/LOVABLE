package com.MAJORPROJECT.LOVABLE.dto.member;

import com.MAJORPROJECT.LOVABLE.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(

       @NotNull ProjectRole role
) {
}
