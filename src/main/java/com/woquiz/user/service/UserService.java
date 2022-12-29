package com.woquiz.user.service;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.woquiz.user.User;
import com.woquiz.user.repository.UserRepository;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getByUsername(String username){
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserDetails getUserDetails(String username) {
        User user = getByUsername(username);
        return convertToUserDetails(user);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    private UserDetails convertToUserDetails(User user){
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
