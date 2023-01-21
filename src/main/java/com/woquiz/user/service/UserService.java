package com.woquiz.user.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.woquiz.user.model.User;

public interface UserService {
    User getByUsername(String username);
    UserDetails getUserDetails(String username);
    User addUser(User user);
}
