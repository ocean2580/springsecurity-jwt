package com.ocean.springsecurityjwt;

import com.ocean.entity.User;
import com.ocean.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringSecurityJwtApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {

        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
