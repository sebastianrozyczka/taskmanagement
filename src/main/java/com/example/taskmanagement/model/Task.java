package com.example.taskmanagement.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate completionDate;

    private BigDecimal duration;

    private boolean finished;
}
