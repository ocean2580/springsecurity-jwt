package com.ocean.handler;

import com.alibaba.fastjson.JSON;
import com.ocean.entity.ResponseResult;
import com.ocean.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult responseResult = // 授权失败
                new ResponseResult(HttpStatus.FORBIDDEN.value(), "您的权限不足");
        String json  = JSON.toJSONString(responseResult);
        WebUtils.renderString(response, json);
    }
}
