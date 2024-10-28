package com.tasktrackerapi.service.impl;

import com.tasktrackerapi.dto.ProjectAddDTO;
import com.tasktrackerapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    @Override
    public void addProject(ProjectAddDTO projectAddDTO) {

    }

    @Override
    public void deleteProject(Long projectId) {

    }
}
