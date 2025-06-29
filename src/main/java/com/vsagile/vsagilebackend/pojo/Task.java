package com.vsagile.vsagilebackend.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "task", schema = "vs_agile_database")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "task_name", nullable = false, length = 50)
    private String taskName;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "assignees")
    private Integer assignees;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "due_time")
    private Instant dueTime;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @Column(name = "status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

}