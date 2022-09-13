package com.ocean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        // 调试，断点，计算器，run.getBean(...)
        ConfigurableApplicationContext run = SpringApplication.run(SpringSecurityJwtApplication.class, args);
        System.out.println(111);
    }

}
