package com.mysql.demo.controller;

import com.mysql.demo.dto.ChangePasswordDTO;
import com.mysql.demo.dto.UserDTO;
import com.mysql.demo.entity.User;
import com.mysql.demo.service.UserService;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody @Valid UserDTO user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid UserDTO user) {
        return userService.login(user);
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestBody @Valid ChangePasswordDTO user) {
        return userService.changePassword(user);
    }
}
