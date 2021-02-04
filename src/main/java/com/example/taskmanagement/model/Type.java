package com.example.taskmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Type {
    JOB("Job"),
    HOME("Home"),
    LEARNING("Learning"),
    OTHER("Other");

    private final String value;
}
