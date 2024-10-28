package com.tasktrackerapi.dto.mapper;

import com.tasktrackerapi.dto.ProjectGetDTO;
import com.tasktrackerapi.model.Project;

import java.util.function.Function;

public class ProjectGetDTOMapper implements Function<Project,ProjectGetDTO> {
    @Override
    public ProjectGetDTO apply(Project project) {
        return new ProjectGetDTO(
                project.getName()
        );
    }
}
