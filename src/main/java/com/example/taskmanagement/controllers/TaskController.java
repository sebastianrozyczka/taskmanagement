package com.example.taskmanagement.controllers;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) Boolean finished) {
        List<Task> taskList;
        if (finished != null) {
            taskList = taskService.findAllByFinishedOrderByDeadline(finished);
        } else {
            taskList = taskService.findAllByOrderByDeadline();
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
        taskService.save(task);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id) {
        Task task = taskService.getById(id);
        model.addAttribute("task", task);

        return "edit";
    }

    @RequestMapping("/done/{id}")
    public String markAsDone(@PathVariable("id") Long id) {
        taskService.markAsDone(id);

        return "redirect:/";
    }
}
