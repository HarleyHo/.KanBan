package com.vsagile.vsagilebackend.controller;

import com.vsagile.vsagilebackend.pojo.ResponseMessage;
import com.vsagile.vsagilebackend.pojo.Project;
import com.vsagile.vsagilebackend.pojo.dto.ProjectDto;
import com.vsagile.vsagilebackend.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    IProjectService projectService;

    @PostMapping
    public ResponseMessage<?> addProject(@Validated @RequestBody ProjectDto projectDto){
        Project project = projectService.add(projectDto);
        return ResponseMessage.success(project);
    }

    @GetMapping("/{projectId}")
    public ResponseMessage<?> getProject(@PathVariable Integer projectId) {
        Project project = projectService.get(projectId);
        return ResponseMessage.success(project);
    }

    @PutMapping
    public ResponseMessage<?> editProject(@Validated @RequestBody ProjectDto projectDto) {
        Project project = projectService.edit(projectDto);
        return ResponseMessage.success(project);
    }

    @DeleteMapping("/{projectId}")
    public ResponseMessage<?> deleteProject(@PathVariable Integer projectId) {
        projectService.delete(projectId);
        return ResponseMessage.success();
    }
}
