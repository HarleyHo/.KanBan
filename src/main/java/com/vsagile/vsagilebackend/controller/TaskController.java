package com.vsagile.vsagilebackend.controller;

import com.vsagile.vsagilebackend.pojo.ResponseMessage;
import com.vsagile.vsagilebackend.pojo.Task;
import com.vsagile.vsagilebackend.pojo.dto.TaskDto;
import com.vsagile.vsagilebackend.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    ITaskService taskService;

    @PostMapping
    public ResponseMessage<?> addTask(@Validated @RequestBody TaskDto taskDto){
        Task task = taskService.add(taskDto);
        return ResponseMessage.success(task);
    }

    @GetMapping("/{taskId}")
    public ResponseMessage<?> getTask(@PathVariable Integer taskId) {
        Task task = taskService.get(taskId);
        return ResponseMessage.success(task);
    }

    @PutMapping
    public ResponseMessage<?> editTask(@Validated @RequestBody TaskDto taskDto) {
        Task task = taskService.edit(taskDto);
        return ResponseMessage.success(task);
    }

    @DeleteMapping("/{taskId}")
    public ResponseMessage<?> deleteTask(@PathVariable Integer taskId) {
        taskService.delete(taskId);
        return ResponseMessage.success();
    }

}
