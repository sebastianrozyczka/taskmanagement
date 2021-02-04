package com.example.taskmanagement.repositories;

import com.example.taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByFinishedOrderByDeadline(boolean finished);

    List<Task> findAllByOrderByDeadline();
}
