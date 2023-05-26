package com.springweb.flux.service;


import com.springweb.flux.dto.MyRequest;
import com.springweb.flux.dto.MyResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ServiceNormal {

    public MyResponse m1(int i ){
        var res = new MyResponse(i*i);
        return res;
    }

    public List<MyResponse> m2 (int i){
     return    IntStream.rangeClosed(1,5)
                //foreach
                .peek(value -> Util.sleepSecond(1))
                .peek(value -> System.out.println("processing :"+value) )
                .mapToObj(value -> new MyResponse(i*value))
                .collect(Collectors.toList());
    }

}
