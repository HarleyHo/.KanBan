package com.vsagile.vsagilebackend.pojo.dto;

import com.vsagile.vsagilebackend.pojo.Task;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.vsagile.vsagilebackend.pojo.Event}
 */
@AllArgsConstructor
@Getter
@ToString
public class EventDto implements Serializable {
    private final Integer id;
    @Size(max = 50)
    private final String eventName;
    @NotNull
    private final Integer managerId;
    private final Integer status;
    @Size(max = 255)
    private final String startDate;
    @Size(max = 255)
    private final String endDate;
    private final Set<Task> tasks;
}