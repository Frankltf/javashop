package com.ltf.shop.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Async
public class AsyncTask {
    public Future<String> task1() throws InterruptedException {
        long begin=System.currentTimeMillis();
        Thread.sleep(200);
        long end=System.currentTimeMillis();
        System.out.println("任务耗时one"+(end-begin));
        return  new AsyncResult<String>("one");
    }

    public Future<String> task2() throws InterruptedException {
        long begin=System.currentTimeMillis();
        Thread.sleep(800);
        long end=System.currentTimeMillis();
        System.out.println("任务耗时two"+(end-begin));
        return  new AsyncResult<String>("two");
    }

    public Future<String> task3() throws InterruptedException {
        long begin=System.currentTimeMillis();
        Thread.sleep(500);
        long end=System.currentTimeMillis();
        System.out.println("任务耗时three"+(end-begin));
        return  new AsyncResult<String>("three");
    }
}
