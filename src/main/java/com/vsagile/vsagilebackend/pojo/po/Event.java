package com.vsagile.vsagilebackend.pojo.po;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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
    private String name;

    @Column(name = "manager_id", nullable = false)
    private Integer managerId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<Task> tasks = new LinkedHashSet<>();

}