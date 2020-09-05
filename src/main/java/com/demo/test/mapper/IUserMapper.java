package com.demo.test.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 自定义sql语句
 */
@Component
public interface IUserMapper {

    // 注解使用sql
    @Select("select * from mp_user where user_id = #{userId}")
    Map<String, Object> getMap(@Param("userId") long userId);

    // sql语句映射写在mapper.xml文件中
    @DS("ds2")
    Map<String, Object> getMap2(@Param("userId") long userId);

}
