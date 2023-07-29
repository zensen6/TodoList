package com.TodoList.TodoList.Controller;

import com.TodoList.TodoList.DTO.TodoRequestDTO;
import com.TodoList.TodoList.Entity.Todo;
import com.TodoList.TodoList.Repository.TodoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TodoRepository todoRepository;




    @BeforeEach
    public void MvcSetup(){

        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        todoRepository.deleteAll();

    }

    @Test
    public void CreateTodo() throws Exception{ // throws Exception 이 없으면, writeValueAsStrin 인식을 못한다.

        //given
        String title1 = "test1";
        boolean done1 = true;

        String title2 = "test2";
        boolean done2 = false;

        String url = "/create";

        //TodoRequestDTO dto = TodoRequestDTO.builder().title(title1).done(done1).build();
        TodoRequestDTO dto = new TodoRequestDTO(title1, done1);
        final String requestBody = objectMapper.writeValueAsString(dto);

        //when
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        //then
        result.andExpect(status().isOk());

        List<Todo> TodoList = todoRepository.findAll();
        assertThat(TodoList.size()).isEqualTo(1);
        assertThat(TodoList.get(0).getTitle()).isEqualTo("test1");
    }




}