package com.TodoList.TodoList.DTO;


import com.TodoList.TodoList.Entity.Todo;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class TodoRequestDTO {

    private Long id;
    private String title;
    private boolean done;


    public TodoRequestDTO(final Todo entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }


    public static Todo toEntity(final TodoRequestDTO dto){
        return Todo.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }



}
