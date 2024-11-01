package com.ivokriki.rest.client.logging.todo;

import com.ivokriki.rest.client.logging.post.PostClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

public class TodoClient {

    private static Logger log = LoggerFactory.getLogger(PostClient.class);
    private final RestClient restClient;

    public TodoClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public todoClient(RestClient.Builder builder, ClientLoggerRequestInterceptor clientLoggerRequestInterceptor){
        this.restClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .requestInterceptor(clientLoggerRequestInterceptor)
                .build();
    }

    public List<Todo> findAll(){
        return  restClient.get()
                .uri("/todos")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Todo>>() {});
    }

}
