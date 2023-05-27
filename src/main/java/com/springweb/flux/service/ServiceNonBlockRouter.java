package com.springweb.flux.service;

import com.springweb.flux.dto.MyResponse;
import com.springweb.flux.exception.InputExceptionRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class ServiceNonBlockRouter {
    @Autowired
    private ServiceNonBlock myservice;


    public Mono<ServerResponse> m1(ServerRequest request)
    {

        String input = request.pathVariable("input");
        if(Integer.parseInt(input) > 5)
            return Mono.error( new InputExceptionRouter(Integer.parseInt(input)));
        Mono<MyResponse> myResponseMono = myservice.m1(Integer.parseInt(input));
        return ServerResponse.ok().body(myResponseMono,MyResponse.class);
    }
}
