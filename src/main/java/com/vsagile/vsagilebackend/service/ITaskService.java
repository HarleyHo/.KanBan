package com.vsagile.vsagilebackend.service;

import com.vsagile.vsagilebackend.pojo.Task;
import com.vsagile.vsagilebackend.pojo.dto.TaskDto;

public interface ITaskService {
    Task add(TaskDto taskDto);

    Task get(Integer taskId);

    Task edit(TaskDto taskDto);

    void delete(Integer taskId);
}
