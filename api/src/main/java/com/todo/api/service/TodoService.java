package com.todo.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.api.model.TodoEntity;
import com.todo.api.repository.TodoRepository;

@Service
public class TodoService {
    private TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<TodoEntity> retrive() {
        return repository.findAll();
    }

    public List<TodoEntity> create(TodoEntity entity) {
        if (entity == null) {
            throw new RuntimeException("Entity cannot be null");
        }

        repository.save(entity);
        return repository.findByUserId(entity.getUserId());
    }
}
