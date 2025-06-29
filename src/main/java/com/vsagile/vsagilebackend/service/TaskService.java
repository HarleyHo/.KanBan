package com.vsagile.vsagilebackend.service;

import com.vsagile.vsagilebackend.dao.TaskRepository;
import com.vsagile.vsagilebackend.pojo.Task;
import com.vsagile.vsagilebackend.pojo.dto.TaskDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task add(TaskDto taskDto) {
        Task taskPojo = new Task();
        BeanUtils.copyProperties(taskDto, taskPojo);
        return taskRepository.save(taskPojo);
    }

    @Override
    public Task get(Integer taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Task not found"));
    }

    @Override
    public Task edit(TaskDto taskDto) {
        Task taskPojo = new Task();
        BeanUtils.copyProperties(taskDto, taskPojo);
        return taskRepository.save(taskPojo);
    }

    @Override
    public void delete(Integer taskId) {
        taskRepository.deleteById(taskId);
    }
}
