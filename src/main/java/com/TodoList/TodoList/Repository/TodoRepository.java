package com.TodoList.TodoList.Repository;

import com.TodoList.TodoList.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    @Query("select * from Todo t where t.userId = ?1")
    List<Todo> findByUserId(Long id);
}
