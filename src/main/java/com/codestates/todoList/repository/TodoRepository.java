package com.codestates.todoList.repository;

import com.codestates.todoList.entity.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    Optional<Todo> findByTitle(String title);
}
