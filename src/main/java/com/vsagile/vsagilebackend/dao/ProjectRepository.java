package com.vsagile.vsagilebackend.dao;

import com.vsagile.vsagilebackend.pojo.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Integer> {
}
