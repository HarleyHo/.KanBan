package com.vsagile.vsagilebackend.service;


import com.vsagile.vsagilebackend.pojo.User;
import com.vsagile.vsagilebackend.pojo.dto.UserDto;

public interface IUserService {
    User add(UserDto userDto);

    User get(Integer userId);

    User edit(UserDto userDto);

    void delete(Integer userId);

    Iterable<User> getAll();
}
