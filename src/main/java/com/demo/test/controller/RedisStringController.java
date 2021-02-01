package com.demo.test.controller;

import com.demo.test.base.BaseController;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/r")
@Slf4j
public class RedisStringController extends BaseController {

    @PostMapping("/set")
    @ApiOperation(value = "缓存字符串", notes = "缓存字符串操作")
    public String set(String key, String value) {
        return jedis.set(key, value);
    }

    @PostMapping("/get")
    @ApiOperation(value = "查询字符串", notes = "查询字符串")
    public String get(String key) {
        return jedis.get(key);
    }

}
