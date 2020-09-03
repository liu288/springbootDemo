package jedis.tester;

import com.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisPool;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class JedisTester {

    @Autowired
    private JedisPool jedisPool;
    
    @Test
    public void test0() {
        String n = jedisPool.getResource().get("n");
        System.out.println(n);
    }

}
