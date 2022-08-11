package com.example.RealTimeApp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDateTime date;

}
    
