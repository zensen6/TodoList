package com.TodoList.TodoList.DTO;


import com.TodoList.TodoList.Entity.Todo;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class TodoRequestDTO {

    private String title;


    public Todo ConvertToEntity(){
        return Todo.builder().title(this.title).build();
    }

}
