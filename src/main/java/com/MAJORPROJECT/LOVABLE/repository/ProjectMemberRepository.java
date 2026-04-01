package com.MAJORPROJECT.LOVABLE.repository;

import com.MAJORPROJECT.LOVABLE.entity.ProjectMember;
import com.MAJORPROJECT.LOVABLE.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberRepository extends  JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);
}
