package com.danijel_stojanovic.task_manager.repository;

import com.danijel_stojanovic.task_manager.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    void deleteById(Long id);

}
