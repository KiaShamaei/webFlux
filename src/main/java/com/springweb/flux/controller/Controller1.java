package com.springweb.flux.controller;


import com.springweb.flux.dto.MyResponse;
import com.springweb.flux.service.ServiceNormal;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/co1")
public class Controller1 {

    //this is normal blocking controller ...
    private final ServiceNormal serviceNormal ;

    @GetMapping("/m1/{input}")
    public ResponseEntity<MyResponse> m1 (@PathVariable int input ){
        var result = serviceNormal.m1(input);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/m2/{input}")
    public ResponseEntity<List<MyResponse>> m2(@PathVariable int input){
        var result = serviceNormal.m2(input);
        return ResponseEntity.ok(result);
    }
}
