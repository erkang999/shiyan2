package com.kang.shiyan02.service;

import com.kang.shiyan02.domain.User;

public interface UserService {
    boolean login(User user);
    boolean register(User user);
}
