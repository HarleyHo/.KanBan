package com.vsagile.vsagilebackend.service;

import com.vsagile.vsagilebackend.dao.UserRepository;
import com.vsagile.vsagilebackend.pojo.User;
import com.vsagile.vsagilebackend.pojo.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(UserDto userDto) {
        User userPojo = new User();
        BeanUtils.copyProperties(userDto, userPojo);
        return userRepository.save(userPojo);
    }

    @Override
    public User get(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public User edit(UserDto userDto) {
        User userPojo = new User();
        BeanUtils.copyProperties(userDto, userPojo);
        return userRepository.save(userPojo);
    }

    @Override
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }


}
