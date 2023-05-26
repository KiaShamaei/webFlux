package com.springweb.flux.service;

import com.springweb.flux.dto.MyRequest;
import com.springweb.flux.dto.MyResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ServiceNonBlock {

    public Mono<MyResponse> m1(int i) {
        return Mono.fromSupplier(() -> i * i)
                .map(MyResponse::new);
    }

    public Flux<MyResponse> m2(int i) {
        return Flux.range(1, 5)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(item -> System.out.println(item))
                .map(item -> i * item)
                .map(MyResponse::new);
    }
    public Mono<MyResponse> postTest(Mono<MyRequest> requestMono)
    {
        return requestMono
                .map(myRequest -> myRequest.getI()* myRequest.getJ())
                .map(MyResponse::new);
    }
}
