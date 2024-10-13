package com.example.itacademy.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledTask {

//    @Scheduled(fixedRate = 5000)
//    @Scheduled(fixedDelay = 5000)
    @Scheduled(cron = "0 0 12 * * ?")//кожен день 0 12:00
    public void task(){
        System.err.println("Time: " + LocalDateTime.now());
        //...
    }
}
