package com.MAJORPROJECT.LOVABLE.mapper;

import com.MAJORPROJECT.LOVABLE.dto.member.MemberResponse;
import com.MAJORPROJECT.LOVABLE.entity.ProjectMember;
import com.MAJORPROJECT.LOVABLE.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {
    //CHECK ->
    @Mapping(target="userId",source = "id")
    @Mapping(target="projectRole",constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId",source = "user.id")
    @Mapping(target = "username",source = "user.username")
    @Mapping(target = "name",source = "user.name")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
