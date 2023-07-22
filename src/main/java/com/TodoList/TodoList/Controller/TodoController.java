package com.TodoList.TodoList.Controller;


import com.TodoList.TodoList.DTO.TodoRequestDTO;
import com.TodoList.TodoList.Service.TodoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

        todoService.create(todoRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
