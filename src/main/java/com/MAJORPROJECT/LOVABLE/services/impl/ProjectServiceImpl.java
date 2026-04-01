package com.MAJORPROJECT.LOVABLE.services.impl;

import com.MAJORPROJECT.LOVABLE.dto.project.ProjectRequest;
import com.MAJORPROJECT.LOVABLE.dto.project.ProjectResponse;
import com.MAJORPROJECT.LOVABLE.dto.project.ProjectSummaryResponse;
import com.MAJORPROJECT.LOVABLE.entity.Project;
import com.MAJORPROJECT.LOVABLE.entity.User;
import com.MAJORPROJECT.LOVABLE.error.ResourceNotFoundException;
import com.MAJORPROJECT.LOVABLE.mapper.ProjectMapper;
import com.MAJORPROJECT.LOVABLE.repository.ProjectRepository;
import com.MAJORPROJECT.LOVABLE.repository.UserRepository;
import com.MAJORPROJECT.LOVABLE.services.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Service
public class ProjectServiceImpl implements ProjectService {
        ProjectRepository projectRepository;
        UserRepository userRepository;
        ProjectMapper projectMapper;
    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner=userRepository.findById(userId).orElseThrow();
        Project project = Project.builder().name(request.name())
                .owner(owner)
                .isPublic(false)
                .build();

        project=projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }


    @Override
    public ProjectResponse getUserProjectsById(Long id, Long userId) {
        Project project= getAccessibleProjectsById(id,userId);
        return projectMapper.toProjectResponse(project);

    }



    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {

        Project project= getAccessibleProjectsById(id,userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("YOU ARE NOT ALLOWED TO DELETE");
        }
        project.setName(request.name());
        project=projectRepository.save(project);
        return projectMapper.toProjectResponse(project);

    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project= getAccessibleProjectsById(id,userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("YOU ARE NOT ALLOWED TO DELETE");
        }
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {

        var projects=projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);

//    return projectRepository.findAllAccessibleByUser(userId)
//            .stream()
//            .map(project -> projectMapper.toProjectSummaryResponse(project))
//            .collect(Collectors.toList());

    }

    /// INTERNAL FUNCTIONS
    public Project getAccessibleProjectsById(Long projectId, Long userId){
      return  projectRepository.findAllAccessibleProjectbyId(projectId,userId).orElseThrow(()->new ResourceNotFoundException("Project",projectId.toString()));
    }


}
