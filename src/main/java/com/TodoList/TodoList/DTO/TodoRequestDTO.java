package com.TodoList.TodoList.DTO;


import com.TodoList.TodoList.Entity.Todo;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class TodoRequestDTO {

    private String title;
    private boolean done;


    public TodoRequestDTO(final Todo entity){
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }

    public TodoRequestDTO(String title1, boolean done1) {
        this.title = title1;
        this.done = done1;
    }


    public static Todo toEntity(final TodoRequestDTO dto){
        return Todo.builder()
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }
}
