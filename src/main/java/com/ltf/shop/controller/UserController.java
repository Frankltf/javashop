package com.ltf.shop.controller;

import com.ltf.shop.domain.User;
import com.ltf.shop.service.UserService;
import com.ltf.shop.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private AsyncTask asyncTask;

    @Value("${test.url}")
    private String env;

    /**
     * 功能描述: user 保存接口
     * @return
     */
    @GetMapping("add")
    public Object add(){

        User user = new User();
        user.setAge(11);
        user.setCreateTime(new Date());
        user.setName("xdclass");
        user.setPhone("10010000");
        int id = userService.add(user);

        return id;
    }

    @GetMapping("showAll")
    public List<User> showAll()
    {
        List<User> users=userService.getAll();
        return users;
    }

    @GetMapping("addaccount")
    public Object addAcount(){
        try {
            int id=userService.addAccount();
            return id;
        }catch (Exception e){
            System.out.println("aa");
            return 0;
        }finally {
            return 1;
        }
    }


    @GetMapping("aysnctask")
    public Object aysnctask() throws InterruptedException {
        long begin=System.currentTimeMillis();
        Future<String> task1=asyncTask.task1();
        Future<String> task2=asyncTask.task2();
        Future<String> task3=asyncTask.task3();
        long end=System.currentTimeMillis();
        long total=end-begin;

        for (;;){
            if(task1.isDone() && task2.isDone() && task3.isDone()){
                break;
            }
        }
        System.out.println("主任务耗时："+(end-begin));
        return  total;
    }

    @GetMapping("testenv")
    public Object testenv(){
        String field=this.env;
        return  field;
    }
}
