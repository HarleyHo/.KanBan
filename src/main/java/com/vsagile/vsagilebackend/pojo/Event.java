package com.vsagile.vsagilebackend.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "event", schema = "vs_agile_database")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "event_name", length = 50)
    private String eventName;

    @NotNull
    @Column(name = "manager_id", nullable = false)
    private Integer managerId;

    @Column(name = "status")
    private Integer status;

    @Size(max = 255)
    @Column(name = "start_date")
    private String startDate;

    @Size(max = 255)
    @Column(name = "end_date")
    private String endDate;

    @OneToMany(mappedBy = "event")
    private Set<Task> tasks = new LinkedHashSet<>();

}