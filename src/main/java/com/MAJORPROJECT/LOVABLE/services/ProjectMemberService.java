package com.MAJORPROJECT.LOVABLE.services;

import com.MAJORPROJECT.LOVABLE.dto.member.InviteMemberRequest;
import com.MAJORPROJECT.LOVABLE.dto.member.MemberResponse;
import com.MAJORPROJECT.LOVABLE.dto.member.UpdateMemberRoleRequest;
import org.jspecify.annotations.Nullable;


import java.util.List;
public interface ProjectMemberService {

     List<MemberResponse> getProjectMembers(Long projectId, Long userId);

     MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMember(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId);

   MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
