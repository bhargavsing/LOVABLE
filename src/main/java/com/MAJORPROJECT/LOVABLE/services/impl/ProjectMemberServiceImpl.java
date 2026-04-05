package com.MAJORPROJECT.LOVABLE.services.impl;

import com.MAJORPROJECT.LOVABLE.dto.member.InviteMemberRequest;
import com.MAJORPROJECT.LOVABLE.dto.member.MemberResponse;
import com.MAJORPROJECT.LOVABLE.dto.member.UpdateMemberRoleRequest;
import com.MAJORPROJECT.LOVABLE.entity.Project;
import com.MAJORPROJECT.LOVABLE.entity.ProjectMember;
import com.MAJORPROJECT.LOVABLE.entity.ProjectMemberId;
import com.MAJORPROJECT.LOVABLE.entity.User;
import com.MAJORPROJECT.LOVABLE.mapper.ProjectMemberMapper;
import com.MAJORPROJECT.LOVABLE.repository.ProjectMemberRepository;
import com.MAJORPROJECT.LOVABLE.repository.ProjectRepository;
import com.MAJORPROJECT.LOVABLE.repository.UserRepository;
import com.MAJORPROJECT.LOVABLE.services.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class ProjectMemberServiceImpl implements ProjectMemberService {

        ProjectRepository projectRepository;
        ProjectMemberMapper projectMemberMapper;
        ProjectMemberRepository projectMemberRepository;
        UserRepository userRepository;
    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project =getAccessibleProjectsById(projectId,userId);

       return projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();


    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {

        Project project=getAccessibleProjectsById(projectId,userId);

         User invitee = userRepository.findByUsername(request.username()).orElseThrow();

        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Cannot invite Yourself");
        }
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId, invitee.getId());
        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Cannot invite once again");
        }

        ProjectMember member =ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(member);
        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }
//check--> updatememberrole
    @Override
    public MemberResponse updateMember(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
       Project project =getAccessibleProjectsById(projectId,userId);

        ProjectMemberId projectMemberId =new ProjectMemberId(projectId,memberId);

        ProjectMember projectMember =projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(request.role());
        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);

    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project =getAccessibleProjectsById(projectId,userId);

        ProjectMemberId projectMemberId =new ProjectMemberId(projectId,memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Member Not Found");
        }

        projectMemberRepository.deleteById(projectMemberId);

    }

    //INTERNAL FUNCTIONS
    public Project getAccessibleProjectsById(Long projectId, Long userId){
        return  projectRepository.findAllAccessibleProjectbyId(projectId,userId).orElseThrow();
    }
}

