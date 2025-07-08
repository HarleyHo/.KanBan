package com.vsagile.vsagilebackend.service;

import com.vsagile.vsagilebackend.pojo.po.Task;
import com.vsagile.vsagilebackend.pojo.dto.TaskDTO;

public interface ITaskService {
    Task add(TaskDTO taskDto);

    Task get(Integer taskId);

    Task edit(TaskDTO taskDto);

    void delete(Integer taskId);
}
