package com.vsagile.vsagilebackend.repository;

import com.vsagile.vsagilebackend.pojo.po.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
}
