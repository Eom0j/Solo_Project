package com.codestates.todoList.mapper;

import com.codestates.todoList.dto.TodoPatchDto;
import com.codestates.todoList.dto.TodoPostDto;
import com.codestates.todoList.dto.TodoResponseDto;
import com.codestates.todoList.entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo todoPostDtoToTodo(TodoPostDto todoPostDto);
    Todo todoPatchDtoToTodo(TodoPatchDto todoPatchDto);
    TodoResponseDto todoToTodoResponseDto(Todo todo);
    List<TodoResponseDto> todosToTodoResponseDtos(List<Todo> todos);
}
