package com.demo.test.controller;

import com.demo.test.bean.User;
import com.demo.test.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/get/{id}")
    public User test(@PathVariable String id){
        log.info(id);
        return userMapper.selectById(id);
    }

}
