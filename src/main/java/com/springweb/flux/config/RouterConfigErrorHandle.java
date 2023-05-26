package com.springweb.flux.config;

import com.springweb.flux.exception.ErrorResponseRouter;
import com.springweb.flux.exception.InputExceptionRouter;
import com.springweb.flux.service.ServiceNonBlockRouter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@AllArgsConstructor
public class RouterConfigErrorHandle {
    private final ServiceNonBlockRouter serviceNonBlockRouter;
    @Bean
    public RouterFunction<ServerResponse> routerFunctionWithError(){
        return RouterFunctions
                .route()
                .GET("/router/{input}",serviceNonBlockRouter::m1 )
                .onError(InputExceptionRouter.class, (throwable, request) ->
                        ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                )
                .build();

    }
}
