package com.example.taskmanagement.services;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void markAsDone(Long id) {
        Task task = taskRepository.getOne(id);
        task.setFinished(true);
        taskRepository.save(task);
    }

    public Task getById(Long id) {
        return taskRepository.getOne(id);
    }

    public List<Task> findAllByFinishedOrderByDeadline(boolean finished) {
        return taskRepository.findAllByFinishedOrderByDeadline(finished);
    }

    public List<Task> findAllByOrderByDeadline() {
        return taskRepository.findAllByOrderByDeadline();
    }
}
