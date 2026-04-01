package com.MAJORPROJECT.LOVABLE.dto.member;

import com.MAJORPROJECT.LOVABLE.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record InviteMemberRequest(
       @NotBlank @Email String email,
       @NotBlank ProjectRole role
) {
}
