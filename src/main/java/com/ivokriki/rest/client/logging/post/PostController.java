package com.ivokriki.rest.client.logging.post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostClient client;


    public PostController(PostClient client) {
        this.client = client;
    }

    @GetMapping
    public List<Post> findAll(){
        return client.findAll();
    }


}
