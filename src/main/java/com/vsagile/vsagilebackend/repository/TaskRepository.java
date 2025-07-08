package com.vsagile.vsagilebackend.repository;

import com.vsagile.vsagilebackend.pojo.po.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task,Integer> {
}
