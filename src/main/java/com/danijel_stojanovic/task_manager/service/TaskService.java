package com.danijel_stojanovic.task_manager.service;

import com.danijel_stojanovic.task_manager.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task createTask(Task task);
    Optional<Task> getTask(Long id);
    List<Task> getAllTasks();
    void deleteTask(Long id);
    List<Task> getTasksByUserId(Long userId);

}
