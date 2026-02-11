package com.MAJORPROJECT.LOVABLE.controllers;

import com.MAJORPROJECT.LOVABLE.dto.member.InviteMemberRequest;
import com.MAJORPROJECT.LOVABLE.dto.member.MemberResponse;
import com.MAJORPROJECT.LOVABLE.dto.member.UpdateMemberRoleRequest;
import com.MAJORPROJECT.LOVABLE.services.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {
    private final ProjectMemberService projectMemberService;
    @GetMapping
    public ResponseEntity<MemberResponse> getProjectMembers(@PathVariable Long projectId){
        Long userId=1L;
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId,userId));
    }
    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable Long projectId,
                                         @RequestBody InviteMemberRequest request){
        Long userId=1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectMemberService.inviteMember(projectId,request,userId));
    }
    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(@PathVariable Long projectid,
                                                           @PathVariable Long memberId,
                                                           @RequestBody UpdateMemberRoleRequest request){
        Long userId=1L;
        return ResponseEntity.ok(projectMemberService.updateMember(projectid,memberId,request,userId));

    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<MemberResponse> deleteProjectMember(@PathVariable Long projectId,
                                                           @PathVariable Long memberId){
        Long userId=1L;
        return ResponseEntity.ok(projectMemberService.deleteProjectMember(projectId,memberId,userId));
    }
}
