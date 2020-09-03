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
public class JedisHashTester {

    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis;

    @Before
    public void bofore() {
        jedis = jedisPool.getResource();
    }

    @Test
    public void hdel() {
        Long hdel = jedis.hdel("hash01", "k1", "k2");
        System.out.println(hdel);
    }

}
