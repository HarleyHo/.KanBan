package com.vsagile.vsagilebackend.pojo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.vsagile.vsagilebackend.pojo.Task}
 */
@Value
public class TaskDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 50)
    String taskName;
    @Size(max = 1000)
    String description;
    Integer assignees;
    Integer priority;
    Instant dueTime;
    Instant startTime;
    Instant endTime;
    Integer status;
}