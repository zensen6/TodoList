package com.TodoList.TodoList.Repository;

import com.TodoList.TodoList.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
