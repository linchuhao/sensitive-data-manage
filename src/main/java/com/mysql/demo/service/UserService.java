package com.mysql.demo.service;

import com.mysql.demo.dto.ChangePasswordDTO;
import com.mysql.demo.dto.UserDTO;
import com.mysql.demo.entity.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    String register(UserDTO user);

    String login(UserDTO user);

    String changePassword(ChangePasswordDTO user);
}
