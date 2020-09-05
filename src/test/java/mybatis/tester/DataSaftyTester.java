package mybatis.tester;

import com.baomidou.mybatisplus.core.toolkit.AES;
import org.junit.Test;

public class DataSaftyTester {
    
    @Test
    public void test() {
        // 生成 16 位随机 AES 密钥
//        String randomKey = AES.generateRandomKey();
        String randomKey = "71297cfc6a4b44b2";

        // 随机密钥加密
        String result = AES.encrypt("Spring2020#$", randomKey);

        System.out.println(result);
    }
    
}
