package com.springweb.flux.config;

import com.springweb.flux.service.ServiceNonBlockRouter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@AllArgsConstructor
public class RouterConfigErrorHandle {
    private final ServiceNonBlockRouter serviceNonBlockRouter;
    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions
                .route()
                .GET("/router/{input}",serviceNonBlockRouter::m1 )
                .build();

    }
}
