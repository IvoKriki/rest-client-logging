package com.ivokriki.rest.client.logging.post;

import com.ivokriki.rest.client.logging.todo.ClientLoggerRequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class PostClient {

    private static final Logger log = LoggerFactory.getLogger(PostClient.class);
    private RestClient restClient;
    private final ClientLoggerRequestInterceptor clientLoggerRequestInterceptor;

    public PostClient(RestClient.Builder builder, ClientLoggerRequestInterceptor clientLoggerRequestInterceptor){
        this.restClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .requestInterceptor(clientLoggerRequestInterceptor)
                .build();
        this.clientLoggerRequestInterceptor = clientLoggerRequestInterceptor;
    }

    private void logRequest(HttpRequest request, byte[] body){

    }

    private void logResponse(HttpRequest request, ClientHttpResponse response) throws IOException {
        byte[] responseBody = response.getBody().readAllBytes();
        log.info("Response {}", new String(responseBody, StandardCharsets.UTF_8));
    }

    public List<Post> findAll(){
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});
    }

    public Post findAllById(Integer id){
        return restClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .toEntity(Post.class)
                .getBody();
    }

}
