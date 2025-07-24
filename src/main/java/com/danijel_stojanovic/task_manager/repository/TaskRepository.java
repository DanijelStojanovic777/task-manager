package com.danijel_stojanovic.task_manager.repository;

import com.danijel_stojanovic.task_manager.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
    void  deleteById(Long id);
    List<Task> findByUserId(Long userId);

}
