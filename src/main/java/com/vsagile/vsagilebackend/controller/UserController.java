package com.vsagile.vsagilebackend.controller;


import com.vsagile.vsagilebackend.pojo.ResponseMessage;
import com.vsagile.vsagilebackend.pojo.User;
import com.vsagile.vsagilebackend.pojo.dto.UserDto;
import com.vsagile.vsagilebackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseMessage<?> addUser(@Validated @RequestBody UserDto userDto){
        User user = userService.add(userDto);
        return ResponseMessage.success(user);
    }

    @GetMapping("/{userId}")
    public ResponseMessage<?> getUser(@PathVariable Integer userId) {
        User user = userService.get(userId);
        return ResponseMessage.success(user);
    }

    @PutMapping
    public ResponseMessage<?> editUser(@Validated @RequestBody UserDto userDto) {
        User user = userService.edit(userDto);
        return ResponseMessage.success(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseMessage<?> deleteUser(@PathVariable Integer userId) {
        userService.delete(userId);
        return ResponseMessage.success();
    }

    @GetMapping("/all")
    public ResponseMessage<?> getAllUsers() {
        Iterable<User> userList = userService.getAll();
        return ResponseMessage.success(userList);
    }
}
