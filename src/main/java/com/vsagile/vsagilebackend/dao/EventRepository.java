package com.vsagile.vsagilebackend.dao;

import com.vsagile.vsagilebackend.pojo.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event,Integer> {
}
