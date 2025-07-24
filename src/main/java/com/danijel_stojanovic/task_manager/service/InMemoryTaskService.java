package com.danijel_stojanovic.task_manager.service;

import com.danijel_stojanovic.task_manager.repository.TaskRepository;
import com.danijel_stojanovic.task_manager.Task;
import com.danijel_stojanovic.task_manager.repository.UserRepository;
import com.danijel_stojanovic.task_manager.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InMemoryTaskService implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;


    public InMemoryTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = null;
    }

    @Autowired
    public InMemoryTaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Task createTask(Task task) {
        //Check and assign user
        if(task.getAssignedUser() != null) {
            Optional<User> user = userRepository.findById(task.getAssignedUser().getId());
            if(user.isPresent()) {
                task.setAssignedUser(user.get());
            }
            else {
                throw new IllegalArgumentException("User does not exist");
            }
        }
        //Auto dueDate set if it is not forwarded
        if (task.getDueDate() == null) {
            task.setDueDate(LocalDate.now().plusDays(7));
        }
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

}
