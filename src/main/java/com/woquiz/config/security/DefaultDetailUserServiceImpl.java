package com.woquiz.config.security;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.woquiz.user.service.DefaultUserService;

@Service
public class DefaultDetailUserServiceImpl implements UserDetailsService {

    private final DefaultUserService defaultUserService;

    public DefaultDetailUserServiceImpl(DefaultUserService defaultUserService) {
        this.defaultUserService = defaultUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("test","test", Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }

}
