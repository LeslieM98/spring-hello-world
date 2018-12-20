package de.akelsch.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions
                .route(GET("/hello").and(accept(TEXT_PLAIN)), this::hello);
    }

    private Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, World! v6"));
    }
}
