package com.ocean.service.impl;

import com.ocean.entity.LoginUser;
import com.ocean.entity.ResponseResult;
import com.ocean.entity.User;
import com.ocean.service.LoginService;
import com.ocean.utils.JwtUtil;
import com.ocean.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        // AM authenticate认证
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 认证未通过则给出提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("");
        }
        // 认证通过，userid -> jwt -> ResponseResult
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();

        String jwt = JwtUtil.createJWT(userid);

        Map<String,String> map = new HashMap<>();
        map.put("token",jwt);

        // 完整用户信息存入redis, userid -> key
        redisCache.setCacheObject("login:"+userid,loginUser);

        return new ResponseResult(200,"登录成功",map);
    }
}
