package com.springweb.flux.controller;


import com.springweb.flux.dto.MyRequest;
import com.springweb.flux.dto.MyResponse;
import com.springweb.flux.exception.InputException;
import com.springweb.flux.service.ServiceNonBlock;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/co3")
public class Controller3 {
    //this is non-blocking controller ...
    private final ServiceNonBlock serviceNonBlock;

    @GetMapping("/m1/{input}")
    public ResponseEntity<Mono<MyResponse>> m1(@PathVariable int input){
        if(input > 5 ){
            throw new InputException(input);
        }
        var result =  serviceNonBlock.m1(input);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/m2/{input}")
    public ResponseEntity<Flux<MyResponse>> m2(@PathVariable int input){
        var result = serviceNonBlock.m2(input);
        return ResponseEntity.ok(result);
    }
    @GetMapping(value = "/m3/{input}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<Flux<MyResponse>> m3(@PathVariable int input){
        var result = serviceNonBlock.m2(input);
        return ResponseEntity.ok(result);
    }
    @PostMapping("m4")
    public Mono<MyResponse> postTest(@RequestBody Mono<MyRequest> myRequest)
    {
        return serviceNonBlock.postTest(myRequest);
    }
}
