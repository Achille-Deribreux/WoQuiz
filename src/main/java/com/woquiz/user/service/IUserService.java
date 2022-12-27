package com.woquiz.user.service;

import com.woquiz.user.User;

public interface IUserService {
    User getByUsername(String username);
}
