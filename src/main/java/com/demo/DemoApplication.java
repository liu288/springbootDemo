package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.test.mapper")
public class DemoApplication {

    // 秘钥：71297cfc6a4b44b2
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
