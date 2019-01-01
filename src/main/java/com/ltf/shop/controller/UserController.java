package com.ltf.shop.controller;

import com.ltf.shop.domain.User;
import com.ltf.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

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
}
