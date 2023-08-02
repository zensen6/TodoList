package com.TodoList.TodoList.Service;

import com.TodoList.TodoList.DTO.TodoRequestDTO;
import com.TodoList.TodoList.Entity.Todo;

import java.util.List;

public interface TodoServiceImpl {

    List<Todo> findAllTodo();

    Todo create(TodoRequestDTO todoRequestDTO);

    void delete(String id);

}
