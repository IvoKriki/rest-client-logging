package com.ivokriki.rest.client.logging.todo;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class TodoController {

    private final TodoClient todoClient;

    public TodoController(TodoClient todoClient) {
        this.todoClient = todoClient;
    }

    @GetMapping
    public List<Todo> findAll(){
        return todoClient.findAll();
    }

}
