package com.ocean.controller;

import com.ocean.entity.ResponseResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('system:dept:list') || hasAuthority('system:test:list')") // 授权: 是否有(...)的权限
    public String hello() {
        return "hello";
    }

    @RequestMapping("/testCors")
    public ResponseResult testCors() {
        return new ResponseResult(200,"请求成功");
    }

}
