package com.vsagile.vsagilebackend.pojo.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsagile.vsagilebackend.pojo.Project}
 */
@Value
public class ProjectDto implements Serializable {
    Integer projectId;
    String projectName;
    Integer projectManagerId;
    Integer status;
    String description;
    String startDate;
    String endDate;
}