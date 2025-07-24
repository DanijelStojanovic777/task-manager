package com.danijel_stojanovic.task_manager.service;

import com.danijel_stojanovic.task_manager.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    Optional<User> getUser(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);

}
