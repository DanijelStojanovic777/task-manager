package com.danijel_stojanovic.task_manager;

import com.danijel_stojanovic.task_manager.repository.InMemoryTaskRepository;
import com.danijel_stojanovic.task_manager.repository.InMemoryUserRepository;
import com.danijel_stojanovic.task_manager.repository.TaskRepository;
import com.danijel_stojanovic.task_manager.service.InMemoryTaskService;
import com.danijel_stojanovic.task_manager.service.TaskService;
import com.danijel_stojanovic.task_manager.service.inMemoryUserService;
import com.danijel_stojanovic.task_manager.repository.UserRepository;
import com.danijel_stojanovic.task_manager.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskManagerApplication {

	public static void main(String[] args) {
		   SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Bean
	public UserRepository userRepository() {
		return new InMemoryUserRepository();
	}

	@Bean
	public UserService userService(UserRepository userRepository) {
		return new inMemoryUserService(userRepository);
	}

	@Bean
	public TaskRepository taskRepository() {
		return new InMemoryTaskRepository();
	}

	@Bean
	public TaskService taskService(TaskRepository taskRepository) {
		return new InMemoryTaskService(taskRepository);
	}

}
