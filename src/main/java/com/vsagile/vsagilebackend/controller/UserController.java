package com.vsagile.vsagilebackend.controller;


import com.vsagile.vsagilebackend.pojo.ResponseMessage;
import com.vsagile.vsagilebackend.pojo.dto.UserCreateDTO;
import com.vsagile.vsagilebackend.pojo.dto.UserDTO;
import com.vsagile.vsagilebackend.pojo.vo.UserVO;
import com.vsagile.vsagilebackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/add")
    public ResponseMessage<?> addUser(@Validated @RequestBody UserCreateDTO userCreateDto){
        UserVO userVo = userService.add(userCreateDto);
        return ResponseMessage.success(userVo);
    }

    @GetMapping("/{userId}")
    public ResponseMessage<?> getUser(@PathVariable Integer userId) {
        UserVO userVo = userService.get(userId);
        return ResponseMessage.success(userVo);
    }

    @PutMapping("/edit")
    public ResponseMessage<?> editUser(@Validated @RequestBody UserDTO userDto) {
        UserVO userVo = userService.edit(userDto);
        return ResponseMessage.success(userVo);
    }

    @DeleteMapping("/{userId}")
    public ResponseMessage<?> deleteUser(@PathVariable Integer userId) {
        userService.delete(userId);
        return ResponseMessage.success();
    }

    @GetMapping("/all")
    public ResponseMessage<?> getAllUsers() {
        Iterable<UserVO> userList = userService.getAll();
        return ResponseMessage.success(userList);
    }
}
