package com.springweb.flux.service;


import org.springframework.stereotype.Service;

@Service
public class Util {
    public static void sleepSecond(int second)
    {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
