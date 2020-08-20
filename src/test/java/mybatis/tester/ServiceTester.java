package mybatis.tester;

import com.demo.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ServiceTester {

    private UserService userService;

}
