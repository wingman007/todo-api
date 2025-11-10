package com.coolcsn.todo_api.model;

import jakarta.validation.constraints.NotBlank;
import java.time.Instant;

public class Todo {
    private long id;

    @NotBlank
    private String title;

    private boolean completed;
    private Instant createdAt = Instant.now();

    public Todo() {}

    public Todo(long id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
        this.createdAt = Instant.now();
    }

    // getters and setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
