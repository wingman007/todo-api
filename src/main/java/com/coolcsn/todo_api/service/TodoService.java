package com.coolcsn.todo_api.service;

import com.coolcsn.todo_api.model.Todo;
import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> findAll();
    Optional<Todo> findById(long id);
    Todo create(String title);
    Todo updateTitle(long id, String newTitle);
    Todo setCompleted(long id, boolean completed);
    void delete(long id);
}
