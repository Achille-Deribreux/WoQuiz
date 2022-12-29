package com.woquiz.config.security;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.woquiz.user.repository.UserRepository;
import com.woquiz.user.service.UserService;

@Service
public class DefaultDetailUserServiceImpl implements UserDetailsService {

    private final UserService userService;

    public DefaultDetailUserServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("test","test", Collections.emptyList());
    }

}
