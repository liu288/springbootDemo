package jedis.tester;

import com.demo.DemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class JedisTester {

    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis;

    @Before
    public void bofore() {
        jedis = jedisPool.getResource();
    }
    
    @Test
    public void test01() {
        String n = jedisPool.getResource().get("q");
        System.out.println(n);
    }

    @Test
    public void test02() {

        System.out.println();
    }

}
