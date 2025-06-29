package com.vsagile.vsagilebackend.dao;

import com.vsagile.vsagilebackend.pojo.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task,Integer> {
}
