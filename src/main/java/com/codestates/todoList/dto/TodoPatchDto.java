package com.codestates.todoList.dto;

import com.codestates.todoList.validator.NotSpace;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class TodoPatchDto {
    private long todoId;

    @NotSpace
    private String title;

    @NotNull
    private boolean completed;


    public void setTodoId(long todoId) {
        this.todoId = todoId;
    }
}
