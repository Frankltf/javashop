package com.ltf.shop.service.impl;

import com.ltf.shop.domain.User;
import com.ltf.shop.mapper.UserMapper;
import com.ltf.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        userMapper.insert(user);
        int id=user.getId();
        return id;
    }

    @Override
    public List<User> getAll() {
        List<User> users=userMapper.getAll();
        return users;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addAccount() {
        User user=new User();
        user.setAge(77);
        user.setCreateTime(new Date());
        user.setName("heheheh");
        user.setPhone("484848485");
        int id=userMapper.insert(user);
        int i=3/0;
        return id;
    }
}
