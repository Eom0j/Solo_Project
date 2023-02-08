package com.codestates.todoList.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class TodoPostDto {
    @NotBlank
    private String title;

    @NotNull
    private int todo_order;

    @NotNull
    private boolean completed;
}
