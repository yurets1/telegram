package com.example.RealTimeApp.controller;

import com.example.RealTimeApp.entity.Task;
import com.example.RealTimeApp.service.task.TaskServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class RestTaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @PostMapping("/save")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
       Task task1 = taskService.saveTask(task);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(task1.getId())
                .toUri();
       return ResponseEntity.created(uri).body(task1);
    }
}
