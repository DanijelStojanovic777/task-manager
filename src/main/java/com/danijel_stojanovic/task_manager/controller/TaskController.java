package com.danijel_stojanovic.task_manager.controller;


import org.springframework.web.bind.annotation.*;

import com.danijel_stojanovic.task_manager.Task;
import com.danijel_stojanovic.task_manager.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private Long userId;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public Optional<Task> getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTaskByUserId(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }

}
