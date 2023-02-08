package com.codestates.todoList.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.Valid;

@Getter
@Setter
public class Todo {
    @Id
    private long todoId;

    private String title;

    private int todo_order;

    private boolean completed;
}
