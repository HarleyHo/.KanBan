package com.vsagile.vsagilebackend.pojo.dto;

import com.vsagile.vsagilebackend.pojo.po.Task;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Task}
 */
@AllArgsConstructor
@Getter
@ToString
public class TaskDTO implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 50)
    private final String name;
    @Size(max = 1000)
    private final String description;
    private final Integer assigneeId;
    private final Integer priority;
    private final LocalDate dueDate;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Integer status;
    private final Integer eventId;
}