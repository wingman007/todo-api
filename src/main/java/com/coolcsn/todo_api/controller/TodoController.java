package com.coolcsn.todo_api.controller;

import com.coolcsn.todo_api.controller.dto.CreateTodoRequest;
import com.coolcsn.todo_api.controller.dto.UpdateTodoRequest;
import com.coolcsn.todo_api.exception.NotFoundException;
import com.coolcsn.todo_api.model.Todo;
import com.coolcsn.todo_api.service.TodoService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*") // Enables frontend in a browser
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Todo byId(@PathVariable long id) {
        return service.findById(id).orElseThrow(() ->
                new NotFoundException("Todo " + id + " not found"));
    }

    @PostMapping
    public Todo create(@Valid @RequestBody CreateTodoRequest req) {
        return service.create(req.getTitle());
    }

    @PatchMapping("/{id}")
    public Todo patch(@PathVariable long id,
                      @RequestBody UpdateTodoRequest req) {

        Todo t = service.findById(id)
                .orElseThrow(() -> new NotFoundException("Todo " + id + " not found"));

        if (req.getTitle() != null)
            t = service.updateTitle(id, req.getTitle());

        if (req.getCompleted() != null)
            t = service.setCompleted(id, req.getCompleted());

        return t;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
