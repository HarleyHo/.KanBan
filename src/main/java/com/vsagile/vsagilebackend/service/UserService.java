package com.vsagile.vsagilebackend.service;

import com.vsagile.vsagilebackend.pojo.dto.UserDTO;
import com.vsagile.vsagilebackend.repository.UserRepository;
import com.vsagile.vsagilebackend.pojo.po.User;
import com.vsagile.vsagilebackend.pojo.dto.UserCreateDTO;
import com.vsagile.vsagilebackend.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    private UserVO convertToVO(User user) {
        return new UserVO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getIconUrl()
        );
    }

    @Override
    public UserVO add(UserCreateDTO userCreateDto) {
        User userPojo = new User();
        BeanUtils.copyProperties(userCreateDto, userPojo);
        return convertToVO(userRepository.save(userPojo));
    }

    @Override
    public UserVO get(Integer userId) {
        User userPojo = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return convertToVO(userPojo);
    }

    @Override
    public UserVO edit(UserDTO userDto) {
        User userPojo = new User();
        BeanUtils.copyProperties(userDto, userPojo);
        return convertToVO(userRepository.save(userPojo));
    }

    @Override
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Iterable<UserVO> getAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(this::convertToVO).collect(Collectors.toList());
    }


}
