package com.example.RealTimeApp.repository;

import com.example.RealTimeApp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
