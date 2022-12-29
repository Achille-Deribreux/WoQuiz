package com.woquiz.user.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.woquiz.user.User;

public interface IUserService {
    User getByUsername(String username);
    UserDetails getUserDetails(String username);
    User addUser(User user);
}
