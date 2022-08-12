package com.example.RealTimeApp.controller;

import com.example.RealTimeApp.entity.Task;
import com.example.RealTimeApp.service.task.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class MainController {
    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping("/")
    public String createTask(Model model) {
        model.addAttribute("task", new Task());
        return "/html/main";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute Task task) {
        task.setDate(LocalDate.now().atTime(LocalDateTime.now().getHour(),LocalDateTime.now().getMinute()));
        taskService.saveTask(task);

        return "redirect:/";
    }

}
