package com.ocean.service;

import com.ocean.entity.ResponseResult;
import com.ocean.entity.User;

public interface LoginService {
    ResponseResult login(User user);
}
