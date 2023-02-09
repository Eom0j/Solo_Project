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
//boolean의 래퍼클래스인 Boolean으로 적용 시키면 Service 의 update 매서드에서 getCompleted로 적용시킬수 있다.