package com.example.RealTimeApp.service.task;

import com.example.RealTimeApp.entity.Task;
import com.example.RealTimeApp.repository.TaskRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private final TaskRepo taskRepo;

    @Override
    public Task saveTask(Task task) {
       return taskRepo.save(task);
    }
}
