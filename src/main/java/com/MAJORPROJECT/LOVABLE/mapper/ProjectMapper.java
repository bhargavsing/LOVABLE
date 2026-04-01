package com.MAJORPROJECT.LOVABLE.mapper;

import com.MAJORPROJECT.LOVABLE.dto.project.ProjectResponse;
import com.MAJORPROJECT.LOVABLE.dto.project.ProjectSummaryResponse;
import com.MAJORPROJECT.LOVABLE.entity.Project;
import com.MAJORPROJECT.LOVABLE.enums.ProjectRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);
}
