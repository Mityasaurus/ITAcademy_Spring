package com.example.itacademy.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AsyncService {

    @Async
    public void asyncMethod(){
        System.err.println("Start");
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.err.println("Finish");
    }
}
