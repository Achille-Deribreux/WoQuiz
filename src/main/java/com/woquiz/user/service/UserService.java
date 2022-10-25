package com.woquiz.user.service;

import org.springframework.stereotype.Service;

import com.woquiz.user.User;

@Service
public class UserService {

    public User getByUsername(String username){
        return new User();//TODO
    }
}
