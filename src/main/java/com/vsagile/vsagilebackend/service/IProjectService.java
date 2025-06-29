package com.vsagile.vsagilebackend.service;

import com.vsagile.vsagilebackend.pojo.Project;
import com.vsagile.vsagilebackend.pojo.dto.ProjectDto;

public interface IProjectService {
    Project add(ProjectDto projectDto);

    Project get(Integer projectId);

    Project edit(ProjectDto projectDto);

    void delete(Integer projectId);
}
