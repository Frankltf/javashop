package com.ltf.shop.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Check {

    @Scheduled(fixedRate = 200)
    public void sum(){
        System.out.println("当前时间"+new Date());
    }
}
