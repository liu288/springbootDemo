package mybatis.tester;

import com.demo.DemoApplication;
import com.demo.test.bean.User;
import com.demo.test.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class PrimaryKeyTester {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        User user = new User();
//        user.setId(1999L); // 如果指定id则使用指定的id,未指定则生成一个id
//        user.setName("liuxiao_test");
        int res = userMapper.insert(user);
        System.out.println(res);
    }

}
