package mybatis.tester;

import com.demo.DemoApplication;
import com.demo.test.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class LogicDeleteTester {

    /*
        说明:
            只对自动注入的sql起效:
                插入: 不作限制
                查找: 追加where条件过滤掉已删除数据,且使用 wrapper.entity 生成的where条件会忽略该字段
                更新: 追加where条件防止更新到已删除数据,且使用 wrapper.entity 生成的where条件会忽略该字段
                删除: 转变为 更新
     */

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        // UPDATE mp_user SET deleted=1 WHERE user_id=? AND deleted=0
        int i = userMapper.deleteById(1999L);
        System.out.println(i);
    }

}
