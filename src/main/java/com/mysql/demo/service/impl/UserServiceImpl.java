package com.mysql.demo.service.impl;

import static org.springframework.util.ObjectUtils.isEmpty;

import com.mysql.demo.dto.ChangePasswordDTO;
import com.mysql.demo.dto.UserDTO;
import com.mysql.demo.entity.User;
import com.mysql.demo.repository.UserRepository;
import com.mysql.demo.service.UserService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String register(UserDTO user) {
        User realUser = userRepository.findByUsername(user.getUsername());
        if (!isEmpty(realUser)) {
            return "This user already exist.";
        }
        User newUser = new User();
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        userRepository.save(newUser);
        return "success";
    }

    @Override
    public String login(UserDTO user) {
        User realUser = userRepository.findByUsername(user.getUsername());
        if (isEmpty(realUser)) {
            return "This user does not exist";
        }
        if (realUser.getPassword().equals(user.getPassword())) {
            return "success";
        }
        return "Please enter the correct password";
    }

    @Override
    public String changePassword(ChangePasswordDTO user) {
        User realUser = userRepository.findByUsername(user.getUsername());
        if (isEmpty(realUser)) {
            return "This user does not exist";
        }
        if (!realUser.getPassword().equals(user.getPassword())) {
            return "Please enter the correct password";
        }
        if (realUser.getPassword().equals(user.getNewPassword())) {
            return "The new password cannot be the same as the old password";
        }
        if (realUser.getPassword().equals(user.getPassword())) {
            realUser.setPassword(user.getNewPassword());
            userRepository.save(realUser);
            return "success";
        }
        return "fail";
    }
}
