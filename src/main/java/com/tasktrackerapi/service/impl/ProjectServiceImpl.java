package com.tasktrackerapi.service.impl;

import com.tasktrackerapi.dto.ProjectAddDTO;
import com.tasktrackerapi.dto.ProjectGetDTO;
import com.tasktrackerapi.dto.mapper.ProjectGetDTOMapper;
import com.tasktrackerapi.model.Project;
import com.tasktrackerapi.repository.ProjectRepository;
import com.tasktrackerapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final ProjectGetDTOMapper projectGetDTOMapper;

    @Override
    public void addProject(ProjectAddDTO projectAddDTO) {
        Project project = new Project();
        project.setName(projectAddDTO.name());
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long projectId) {
        if (projectRepository.existsById(projectId)) {
            projectRepository.deleteById(projectId);
        } else {
            throw new IllegalArgumentException("Project not found with ID: " + projectId);
        }
    }

    @Override
    public List<ProjectGetDTO> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(projectGetDTOMapper)
                .collect(Collectors.toList());
    }
}
