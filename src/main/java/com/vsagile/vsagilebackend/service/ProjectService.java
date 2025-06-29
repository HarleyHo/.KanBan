package com.vsagile.vsagilebackend.service;

import com.vsagile.vsagilebackend.dao.ProjectRepository;
import com.vsagile.vsagilebackend.pojo.Project;
import com.vsagile.vsagilebackend.pojo.Task;
import com.vsagile.vsagilebackend.pojo.dto.ProjectDto;
import com.vsagile.vsagilebackend.pojo.dto.TaskDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project add(ProjectDto projectDto) {
        Project projectPojo = new Project();
        BeanUtils.copyProperties(projectDto, projectPojo);
        return projectRepository.save(projectPojo);
    }

    @Override
    public Project get(Integer projectId) {
        return projectRepository.findById(projectId).orElseThrow(() -> new IllegalArgumentException("Project not found"));
    }

    @Override
    public Project edit(ProjectDto projectDto) {
        Project projectPojo = new Project();
        BeanUtils.copyProperties(projectDto, projectPojo);
        return projectRepository.save(projectPojo);
    }

    @Override
    public void delete(Integer projectId) {
        projectRepository.deleteById(projectId);
    }
}
