package com.danijel_stojanovic.task_manager.repository;

import com.danijel_stojanovic.task_manager.Task;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryTaskRepository implements TaskRepository {

    private final Map<Long, Task> tasks = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(counter.getAndIncrement());
        }
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public void deleteById(Long id) {
        tasks.remove(id);
    }

    @Override
    public List<Task> findByUserId(Long userId) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getAssignedUser() != null && userId.equals(task.getAssignedUser().getId())) {
                result.add(task);
            }
        }
        return result;
    }

}
