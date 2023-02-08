package com.codestates.todoList.service;

import com.codestates.todoList.entity.Todo;
import com.codestates.todoList.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo) {
        verifyExistTitle(todo.getTitle());

        return todoRepository.save(todo);
    }


    public Todo updateTodo(Todo todo) {
        Todo findTodo = findVerifiedTodo(todo.getTodoId());

        Optional.ofNullable(todo.getTitle())
                .ifPresent(title -> findTodo.setTitle(title));
        Optional.ofNullable(todo.isCompleted())
                .ifPresent(completed -> findTodo.setCompleted(completed));

        return todoRepository.save(findTodo);
    }

    public Todo findTodo(long todoId) {
        return findVerifiedTodo(todoId);
    }

    public List<Todo> findTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    public void deleteTodo(long todoId) {
        Todo findTodo = findVerifiedTodo(todoId);

        todoRepository.delete(findTodo);
    }

    public void deleteTodos() {
        todoRepository.deleteAll();
    }

    private void verifyExistTitle(String title) {
        Optional<Todo> todo = todoRepository.findByTitle(title);
        if (todo.isPresent())
            throw new RuntimeException();
    }

    public Todo findVerifiedTodo(long todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        Todo findTodo = optionalTodo.orElseThrow(() -> new RuntimeException());

        return findTodo;
    }
}
