package com.woquiz.user.service;

import java.util.Collections;

import org.hibernate.mapping.Collection;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.woquiz.user.User;

@Service
public class UserService implements IUserService {


    @Override
    public User getByUsername(String username){
        return new User();//TODO
    }

    @Override
    public UserDetails getUserDetails(String username) {
        User user = getByUsername(username);
        return convertToUserDetails(user);
    }

    private UserDetails convertToUserDetails(User user){
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
