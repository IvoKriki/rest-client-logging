package com.ivokriki.rest.client.logging.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestClient;

import java.util.List;

public class PostClient {

    private static final Logger log = LoggerFactory.getLogger(PostClient.class);
    private RestClient restClient;

    public PostClient(RestClient.Builder builder){
        this.restClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .requestInterceptor(((request, body, execution) -> {
                    logRequest(request, body);
                    var response = execution.execute(request, body);
                    logResponse(request, response);
                    return response;
                }))
                .build();
    }

    private void logRequest(HttpRequest request, byte[] body){

    }

    private void logResponse(HttpRequest request, ClientHttpResponse response){

    }

    public List<Post> findAll(){
        return restClient.get()
                .uri("/post")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    public Post findAllById(Integer id){
        return restClient.get()
                .uri("/post/{id}", id)
                .retrieve()
                .toEntity(Post.class)
                .getBody();
    }

}