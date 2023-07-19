package com.TodoList.TodoList.Service;


import com.TodoList.TodoList.Entity.Todo;
import com.TodoList.TodoList.Repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService implements TodoServiceImpl{

    @Autowired
    private final TodoRepository todoRepository; //RequiredArgs 필요함


    @Override
    public List<Todo> findAllTodo(){
        List<Todo> TodoList = todoRepository.findAll();
        return TodoList;
    }

}
