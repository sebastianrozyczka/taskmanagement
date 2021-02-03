package com.example.taskmanagement.repositories;

import com.example.taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByFinishedOrderByDeadline(boolean finished);

    List<Task> findAllByOrderByDeadline();
}
