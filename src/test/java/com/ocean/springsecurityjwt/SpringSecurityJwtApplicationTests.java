package com.ocean.springsecurityjwt;

import com.ocean.entity.User;
import com.ocean.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class SpringSecurityJwtApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {

        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void testBCryptPasswordEncoder() {
        String encode = passwordEncoder.encode("1234");
        System.out.println(encode);
        System.out.println(passwordEncoder.matches("1234", encode));
    }
}
