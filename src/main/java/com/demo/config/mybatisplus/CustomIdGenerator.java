package com.demo.config.mybatisplus;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

/**
 * 自定义ID生成器,如果使用则会替换MyBatisPlus自己的生成ID方式
 */
//@Component
public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Long nextId(Object entity) {
        //可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
        String bizKey = entity.getClass().getName();
        //根据bizKey调用分布式ID生成
//        long id = ....;
        long id = 667L; // 这里写死示例，生成ID都会是667
        //返回生成的id值即可.
        return id;
    }

}
