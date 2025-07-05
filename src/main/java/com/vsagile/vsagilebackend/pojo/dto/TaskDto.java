package com.vsagile.vsagilebackend.pojo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.vsagile.vsagilebackend.pojo.Task}
 */
@AllArgsConstructor
@Getter
@ToString
public class TaskDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 50)
    private final String taskName;
    @Size(max = 1000)
    private final String description;
    private final Integer assignee;
    private final Integer priority;
    private final LocalDate dueTime;
    private final LocalDate startTime;
    private final LocalDate endTime;
    private final Integer status;
    private final EventDto event;
}