package com.codestates.todoList.controller;

import com.codestates.todoList.dto.TodoPatchDto;
import com.codestates.todoList.dto.TodoPostDto;
import com.codestates.todoList.dto.TodoResponseDto;
import com.codestates.todoList.entity.Todo;
import com.codestates.todoList.mapper.TodoMapper;
import com.codestates.todoList.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/todos")
@Validated
@Slf4j
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper mapper;

    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoPostDto todoDto) {
        Todo todo = mapper.todoPostDtoToTodo(todoDto);

        Todo response = todoService.createTodo(todo);

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(response),HttpStatus.CREATED);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") @Positive long todoId,
                                    @Valid @RequestBody TodoPatchDto todoPatchDto) {
        todoPatchDto.setTodoId(todoId);

        Todo response = todoService.updateTodo(mapper.todoPatchDtoToTodo(todoPatchDto));

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") @Positive long todoId) {
        Todo response = todoService.findTodo(todoId);

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos() {
        List<Todo> todos = todoService.findTodos();
        List<TodoResponseDto> response = mapper.todosToTodoResponseDtos(todos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") @Positive long todoId) {
        System.out.println("# delete todoList");

        todoService.deleteTodo(todoId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteTodos() {
        System.out.println(" delete AllTodoList");

        todoService.deleteTodos();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
