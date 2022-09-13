package com.ocean.controller;

import com.ocean.entity.ResponseResult;
import com.ocean.entity.User;
import com.ocean.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public ResponseResult login(@RequestBody User user) {

        return loginService.login(user);
    }
}
