package com.ocean.handler;

import com.alibaba.fastjson.JSON;
import com.ocean.entity.ResponseResult;
import com.ocean.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult responseResult = // 认证失败
                new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "用户认证失败请查询登录");
        String json  = JSON.toJSONString(responseResult);
        WebUtils.renderString(response, json);
    }
}
