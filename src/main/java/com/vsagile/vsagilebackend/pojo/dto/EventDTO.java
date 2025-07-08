package com.vsagile.vsagilebackend.pojo.dto;

import com.vsagile.vsagilebackend.pojo.po.Event;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Event}
 */
@AllArgsConstructor
@Getter
@ToString
public class EventDTO implements Serializable {
    private final Integer id;
    @Size(max = 50)
    private final String name;
    private final Integer managerId;
    private final Integer status;
    private final LocalDate startDate;
    private final LocalDate endDate;
}