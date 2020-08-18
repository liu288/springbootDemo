package com.demo.test.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.test.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

}
