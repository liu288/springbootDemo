package com.demo.test.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.ModelAttribute;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *  基础contoller，提供共用参数方法
 *
 * @author liuxiao
 * @date 2020/10/22 18:04
 */
public class BaseController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private JedisPool jedisPool;

    protected Jedis jedis;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 初始化jedis
     */
    @ModelAttribute
    public void init(){
        if(jedis == null) {
            jedisPool = applicationContext.getBean(JedisPool.class);
            jedis = jedisPool.getResource();
        }
    }
}
