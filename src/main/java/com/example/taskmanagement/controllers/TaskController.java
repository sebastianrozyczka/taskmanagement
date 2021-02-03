package com.example.taskmanagement.controllers;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repositories.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) Boolean finished) {
        List<Task> taskList;
        if (finished != null) {
            taskList = taskRepository.findAllByFinishedOrderByDeadline(finished);
        } else {
            taskList = taskRepository.findAllByOrderByDeadline();
        }
        model.addAttribute("taskList", taskList);

        return "tasks";
    }

    @GetMapping("/new")
    public String newTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);

        return "new";
    }

    @PostMapping("/save")
    public String saveTask(Task task) {
        taskRepository.save(task);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id) {
        Task task = taskRepository.getOne(id);
        model.addAttribute("task", task);

        return "edit";
    }

    @RequestMapping("/done/{id}")
    public String markAsDone(@PathVariable("id") Long id) {
        Task task = taskRepository.getOne(id);
        task.setFinished(true);
        taskRepository.save(task);

        return "redirect:/";
    }
}
