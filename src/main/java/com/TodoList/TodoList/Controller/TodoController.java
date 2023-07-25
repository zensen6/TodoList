package com.TodoList.TodoList.Controller;


import com.TodoList.TodoList.DTO.ResponseDTO;
import com.TodoList.TodoList.DTO.TodoRequestDTO;
import com.TodoList.TodoList.Entity.Todo;
import com.TodoList.TodoList.Service.TodoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TodoController {


    @Autowired
    private final TodoServiceImpl todoService;

    @GetMapping("/getall")
    public void getAllTodo(){
        todoService.findAllTodo();
        return;
    }


    @PostMapping("/create")
    public ResponseEntity<?> createTodo(@RequestBody TodoRequestDTO todoRequestDTO){

        List<Todo> entities = todoService.create(todoRequestDTO);
        List<TodoRequestDTO> dtos = entities.stream().map(TodoRequestDTO::new).toList();

        ResponseDTO<TodoRequestDTO> response = ResponseDTO.<TodoRequestDTO>builder().data(dtos).build();

        return ResponseEntity.ok().body(response);
    }

}
