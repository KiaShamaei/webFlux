package com.springweb.flux.config;

import com.springweb.flux.exception.ErrorResponseRouter;
import com.springweb.flux.exception.InputExceptionRouter;
import com.springweb.flux.service.ServiceNonBlockRouter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

@Configuration
@AllArgsConstructor
public class RouterConfigErrorHandle {
    private final ServiceNonBlockRouter serviceNonBlockRouter;
    @Bean
    public RouterFunction<ServerResponse> routerFunctionWithError(){
        return RouterFunctions
                .route()
                .GET("/router/{input}",serviceNonBlockRouter::m1 )
                .build();
    }
//    private HandlerFilterFunction<ServerResponse, ServerResponse> dataNotFoundToBadRequest() {
//        return (request, next) -> next.handle(request)
//                .onErrorResume(InputExceptionRouter.class, e -> ServerResponse
//                        .badRequest().build()
//                );
//    }
    @Bean
    WebFilter dataNotFoundToBadRequest() {
        return (exchange, next) -> next.filter(exchange)
                .onErrorResume(InputExceptionRouter.class, e -> {
                    ServerHttpResponse response = exchange.getResponse();
                    response.setStatusCode(HttpStatus.BAD_REQUEST);
                    return response.setComplete();
                });
    }
}
