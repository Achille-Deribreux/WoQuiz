package com.woquiz.user.service;

import java.util.Collections;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.woquiz.user.model.User;
import com.woquiz.user.repository.UserRepository;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getByUsername(String username){
        return userRepository.findByUsername(username).orElse(null); //TODO EXCEPTION
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

    public String getCurrentUser(){ //TODO TEST
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

    private UserDetails convertToUserDetails(User user){ //TODO PUT IN COMMON CONVERTER
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
