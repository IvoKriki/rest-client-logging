
# Rest Client Logging

A Spring Boot project that serves as an HTTP client to consume external APIs, specifically [JSONPlaceholder](https://jsonplaceholder.typicode.com/), and logs detailed information about each request and response. This project demonstrates how to build a robust client that not only retrieves data but also logs request and response details, making it suitable for debugging and monitoring.

## Features

- **Consume JSONPlaceholder API**: Retrieves data from JSONPlaceholder's `/posts` and `/todos` endpoints.
- **Request and Response Logging**: Uses a custom interceptor to log request and response details, including HTTP method, URI, headers, and body content.
- **Spring Boot Integration**: Exposes local endpoints to retrieve data from JSONPlaceholder, functioning as a proxy API.

## Requirements

- Java 17+
- Maven 3.6+
- Spring Boot 3.0+

## Getting Started

1. **Clone the Repository**
   ```bash
   git clone https://github.com/IvoKriki/rest-client-logging.git
   cd rest-client-logging
   ```

2. **Build and Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. **Access Local Endpoints**

   - `GET /posts` - Retrieves a list of posts from JSONPlaceholder.
   - `GET /todos` - Retrieves a list of todos from JSONPlaceholder.

## Usage

This project provides two main endpoints, `/posts` and `/todos`, that proxy requests to JSONPlaceholder's API. The following `curl` commands demonstrate how to interact with the API:

### Fetch All Posts

```bash
curl -X GET http://localhost:8080/posts
```

#### Response
```json
[
    {
        "id": 1,
        "userId": 1,
        "title": "Sample Post Title",
        "body": "Sample post content..."
    },
    ...
]
```

### Fetch All Todos

```bash
curl -X GET http://localhost:8080/todos
```

#### Response
```json
[
    {
        "id": 1,
        "userId": 1,
        "title": "Sample Todo Title",
        "completed": false
    },
    ...
]
```

## Project Structure

- **Controllers**: `PostController` and `TodoController` expose endpoints for `/posts` and `/todos`.
- **Clients**: `PostClient` and `TodoClient` manage the HTTP calls to JSONPlaceholder's endpoints.
- **Interceptors**: `ClientLoggerRequestInterceptor` logs request and response details.

## Logging

The `ClientLoggerRequestInterceptor` logs detailed information about each request and response, including:

- HTTP Method and URI
- Headers and Body
- Response Status Code and Body

This is useful for debugging purposes, as you can inspect the full lifecycle of each HTTP call.

## Examples of Logs

Sample logs generated by the interceptor:

```
2024-11-01T12:54:58.746Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Request: GET https://jsonplaceholder.typicode.com/posts
2024-11-01T12:54:58.749Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Content-Length=[0]
2024-11-01T12:54:59.079Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Response status: 200 OK
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Date=[Fri, 01 Nov 2024 12:54:57 GMT]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Content-Type=[application/json; charset=utf-8]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Transfer-Encoding=[chunked]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Connection=[keep-alive]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Report-To=[{"group":"heroku-nel","max_age":3600,"endpoints":[{"url":"https://nel.heroku.com/reports?ts=1730441596&sid=e11707d5-02a7-43ef-b45e-2cf4d2036f7d&s=gR3Ot34uMv3cQfZOIkQeqANsr8MivdHKNBiZs8IhplU%3D"}]}]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Reporting-Endpoints=[heroku-nel=https://nel.heroku.com/reports?ts=1730441596&sid=e11707d5-02a7-43ef-b45e-2cf4d2036f7d&s=gR3Ot34uMv3cQfZOIkQeqANsr8MivdHKNBiZs8IhplU%3D]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Nel=[{"report_to":"heroku-nel","max_age":3600,"success_fraction":0.005,"failure_fraction":0.05,"response_headers":["Via"]}]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : X-Powered-By=[Express]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : X-Ratelimit-Limit=[1000]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : X-Ratelimit-Remaining=[999]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : X-Ratelimit-Reset=[1730441651]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Vary=[Origin, Accept-Encoding]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Access-Control-Allow-Credentials=[true]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Cache-Control=[max-age=43200]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Pragma=[no-cache]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Expires=[-1]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : X-Content-Type-Options=[nosniff]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Etag=[W/"6b80-Ybsq/K6GwwqrYkAsFxqDXGC7DoM"]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Via=[1.1 vegur]
2024-11-01T12:54:59.081Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : CF-Cache-Status=[HIT]
2024-11-01T12:54:59.082Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Age=[24101]
2024-11-01T12:54:59.082Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Server-Timing=[cfCacheStatus;desc="HIT", cfL4;desc="?proto=TCP&rtt=33936&sent=7&recv=7&lost=0&retrans=0&sent_bytes=3115&recv_bytes=793&delivery_rate=130477&cwnd=49&unsent_bytes=0&cid=32030f8c9988cd04&ts=117&x=0"]
2024-11-01T12:54:59.082Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Server-Timing=[cfCacheStatus;desc="HIT", cfL4;desc="?proto=TCP&rtt=33936&sent=7&recv=7&lost=0&retrans=0&sent_bytes=3115&recv_bytes=793&delivery_rate=130477&cwnd=49&unsent_bytes=0&cid=32030f8c9988cd04&ts=117&x=0"]
2024-11-01T12:54:59.082Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Server=[cloudflare]
2024-11-01T12:54:59.082Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : CF-RAY=[8dbc09514bc863f3-LHR]
2024-11-01T12:54:59.082Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : alt-svc=[h3=":443"; ma=86400]
2024-11-01T12:54:59.086Z  INFO 22852 --- [demo] [nio-8080-exec-1] i.r.c.l.t.ClientLoggerRequestInterceptor : Request body: [
  {
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
  }
  ...
```
> **Note**: This logging setup and approach was inspired by the techniques and practices demonstrated by Dan Vega.