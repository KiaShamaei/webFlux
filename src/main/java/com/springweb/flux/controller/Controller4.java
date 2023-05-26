package com.springweb.flux.controller;


import com.springweb.flux.dto.MyRequest;
import com.springweb.flux.dto.MyResponse;
import com.springweb.flux.exception.InputException;
import com.springweb.flux.exception.InputExceptionRouter;
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
public class Controller4 {
    //this is non-blocking controller with routerFunction error handling ...
    private final ServiceNonBlock serviceNonBlock;

    @GetMapping("/m1/{input}")
    public ResponseEntity<Mono<MyResponse>> m1(@PathVariable int input){
        var result =  serviceNonBlock.m1(input);
        return ResponseEntity.ok(result);
    }

}
