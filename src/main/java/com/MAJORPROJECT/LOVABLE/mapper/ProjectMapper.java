package com.MAJORPROJECT.LOVABLE.mapper;

import com.MAJORPROJECT.LOVABLE.dto.project.ProjectResponse;
import com.MAJORPROJECT.LOVABLE.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toProjectResponse(Project project);

}
