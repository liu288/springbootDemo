package mybatis.tester;

import com.demo.DemoApplication;
import com.demo.test.mapper.IUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class SelfMapperTester {

    @Autowired
    private IUserMapper iUserMapper;

    @Test
    public void test() {
        Map<String, Object> map1 = iUserMapper.getMap(10000);
        System.out.println(map1);

        Map<String, Object> map2 = iUserMapper.getMap2(10001);
        System.out.println(map2);
    }

}
