package com.coolcsn.todo_api.service;

import com.coolcsn.todo_api.model.Todo;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InMemoryTodoService implements TodoService {

    private final Map<Long, Todo> store = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    @Override
    public List<Todo> findAll() {
        return store.values().stream()
                .sorted(Comparator.comparingLong(Todo::getId))
                .toList();
    }

    @Override
    public Optional<Todo> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Todo create(String title) {
        long id = seq.incrementAndGet();
        Todo t = new Todo(id, title);
        store.put(id, t);
        return t;
    }

    @Override
    public Todo updateTitle(long id, String newTitle) {
        Todo t = store.get(id);
        if (t == null) throw new NoSuchElementException("Todo " + id + " not found");
        t.setTitle(newTitle);
        return t;
    }

    @Override
    public Todo setCompleted(long id, boolean completed) {
        Todo t = store.get(id);
        if (t == null) throw new NoSuchElementException("Todo " + id + " not found");
        t.setCompleted(completed);
        return t;
    }

    @Override
    public void delete(long id) {
        store.remove(id);
    }
}
