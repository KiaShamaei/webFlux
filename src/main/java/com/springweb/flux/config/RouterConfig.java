package com.springweb.flux.config;

import com.springweb.flux.dto.MyResponse;
import com.springweb.flux.exception.ErrorResponse;
import com.springweb.flux.exception.InputExceptionRouter;
import com.springweb.flux.service.ServiceNonBlockRouter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@AllArgsConstructor
public class RouterConfig {
    private final ServiceNonBlockRouter serviceNonBlockRouter;
    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions
                .route()
                .GET("/router/{input}",serviceNonBlockRouter::m1 )
                .build();

    }
}
