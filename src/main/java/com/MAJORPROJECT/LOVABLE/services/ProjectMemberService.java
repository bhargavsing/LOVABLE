package com.MAJORPROJECT.LOVABLE.services;

import com.MAJORPROJECT.LOVABLE.dto.member.InviteMemberRequest;
import com.MAJORPROJECT.LOVABLE.dto.member.MemberResponse;
import com.MAJORPROJECT.LOVABLE.dto.member.UpdateMemberRoleRequest;
import org.jspecify.annotations.Nullable;

public interface ProjectMemberService {

     MemberResponse getProjectMembers(Long projectId, Long userId);

     MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMember(Long projectid, Long memberId, UpdateMemberRoleRequest request, Long userId);

   MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
