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
public class MultiDataSourceTester {

    @Autowired
    private IUserMapper iUserMapper;

    @Test
    public void test() {
        Map<String, Object> map = iUserMapper.getMap(999L);
        System.out.println(map);

        Map<String, Object> map2 = iUserMapper.getMap2(0L);
        System.out.println(map2);
    }

}
