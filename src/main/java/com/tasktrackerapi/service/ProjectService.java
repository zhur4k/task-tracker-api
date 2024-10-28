package com.tasktrackerapi.service;

import com.tasktrackerapi.dto.ProjectAddDTO;

public interface ProjectService {

    void addProject(ProjectAddDTO projectAddDTO);

    void deleteProject(Long projectId);
}
