package com.tasktrackerapi.service;

import com.tasktrackerapi.dto.ProjectAddDTO;
import com.tasktrackerapi.dto.ProjectGetDTO;

import java.util.List;

public interface ProjectService {

    void addProject(ProjectAddDTO projectAddDTO);

    void deleteProject(Long projectId);

    List<ProjectGetDTO> getAllProjects();
}
