package com.ltf.shop.service;

import com.ltf.shop.domain.User;

import java.util.List;

public interface UserService {
    public int add(User user);

    public List<User>getAll();
}
