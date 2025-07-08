package com.vsagile.vsagilebackend.service;


import com.vsagile.vsagilebackend.pojo.dto.UserCreateDTO;
import com.vsagile.vsagilebackend.pojo.dto.UserDTO;
import com.vsagile.vsagilebackend.pojo.vo.UserVO;

public interface IUserService {
    UserVO add(UserCreateDTO userCreateDto);

    UserVO get(Integer userId);

    UserVO edit(UserDTO userDto);

    void delete(Integer userId);

    Iterable<UserVO> getAll();
}
