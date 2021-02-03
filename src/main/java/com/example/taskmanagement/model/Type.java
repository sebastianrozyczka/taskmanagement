package com.example.taskmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Type {
    JOB("Job"),
    HOME("Value"),
    LEARNING("Learning"),
    OTHER("Other");

    private final String value;
}
