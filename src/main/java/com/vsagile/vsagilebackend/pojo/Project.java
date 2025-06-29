package com.vsagile.vsagilebackend.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    private String projectName;
    private Integer projectManagerId;
    private Integer status;
    private String description;
    private String startDate;
    private String endDate;

    @OneToMany
    private Set<Task> tasks = new LinkedHashSet<>();

}
