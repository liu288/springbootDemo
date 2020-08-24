package mybatis.tester;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.demo.DemoApplication;
import com.demo.test.bean.User;
import com.demo.test.service.UserService;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ServiceTester {

    @Autowired
    private UserService userService;

    @Test
    public void save() {
        User user = new User();
        user.setId(100L);
        user.setName("100_name");
        boolean b = userService.save(user);
        System.out.println(b);
    }

    @Test
    public void saveBatch() {
        List<User> list = Lists.newArrayList();
        User user;
        for (int i = 0; i < 2500; i++) {
            user = new User();
            user.setId(10000L + i);
            user.setName(user.getId() + "_name");
            list.add(user);
        }
        // 默认每次批量从插入1000条
        boolean b = userService.saveBatch(list, 500);
        System.out.println(b);
    }

    /**
     * 先查询，如果不存在则插入记录
     */
    @Test
    public void saveOrUpdate1() {
        User user = new User();
        user.setId(51L);
        user.setName("50_name");
        //  SELECT user_id AS id,create_time AS date,user_name AS name,email,age FROM mp_user WHERE user_id=?
        //  UPDATE mp_user SET user_name=? WHERE user_id=?
        boolean b = userService.saveOrUpdate(user);
        System.out.println(b);
    }

    /**
     * 根据updateWrapper尝试更新，否继续执行saveOrUpdate(T)方法
     * 如果更新失败，则插入该记录
     */
    @Test
    public void saveOrUpdate2() {
        User user = new User();
        QueryWrapper<User> queryWrapper = Wrappers.<User>query().eq("user_id", 0);
        user.setName("liuxiao");
        // UPDATE mp_user SET user_name=? WHERE (user_id = ?)
        // INSERT INTO mp_user ( user_id, user_name ) VALUES ( ?, ? )
        boolean b = userService.saveOrUpdate(user, queryWrapper);
        System.out.println(b);
    }

    @Test
    public void saveOrUpdateBatch() {
        List<User> list = Lists.newArrayList();
        User user;
        for (int i = 20000; i < 20010; i++) {
            user = new User();
            user.setId((long) i);
            user.setName(i + "_name_u");
            list.add(user);
        }
        // 默认批量1000
        boolean b = userService.saveOrUpdateBatch(list);
        System.out.println(b);
    }

    /**
     * 已删除记录数(n)为判断条件
     * 结果 true：n>0,删除成功
     *      false: n=0,删除失败
     */
    @Test
    public void remove() {
        QueryWrapper<User> queryWrapper = Wrappers.<User>query().eq("user_id", 0);
        boolean b = userService.remove(queryWrapper);
        System.out.println(b);
    }

    /**
     * 已删除记录数(n)为判断条件
     * 结果 true：n>0,删除成功
     *      false: n=0,删除失败
     */
    @Test
    public void removeById() {
        boolean b = userService.removeById(4);
        System.out.println(b);
    }

    /**
     * 已删除记录数(n)为判断条件
     * 结果 true：n>0,删除成功
     *      false: n=0,删除失败
     */
    @Test
    public void reomveByMap() {
        Map<String, Object> map = Maps.newHashMap("user_id", 6);
        boolean b = userService.removeByMap(map);
        System.out.println(b);
    }

    /**
     * 已删除记录数(n)为判断条件
     * 结果 true：n>0,删除成功
     *      false: n=0,删除失败
     */
    @Test
    public void removeByIds() {
        List<Long> idList = Lists.newArrayList(5L, 6L, 7L, 8L);
        boolean b = userService.removeByIds(idList);
        System.out.println(b);
    }

    /**
     * 更新记录数(n)为判断条件
     * 结果 true：n>0,更新成功
     *      false: n=0,更新失败
     */
    @Test
    public void update1() {
        UpdateWrapper<User> userUpdateWrapper = Wrappers.update();
        userUpdateWrapper.eq("user_id", 9);

        userUpdateWrapper.set("user_name", "999");

        boolean n = userService.update(userUpdateWrapper);
        System.out.println(n);
    }

    /**
     * 更新记录数(n)为判断条件
     * 结果 true：n>0,更新成功
     *      false: n=0,更新失败
     */
    @Test
    public void update2() {
        UpdateWrapper<User> userUpdateWrapper = Wrappers.update();
        userUpdateWrapper.eq("user_id", 9);

        User user = new User();
        user.setName("999_666");

        boolean n = userService.update(user, userUpdateWrapper);
        System.out.println(n);
    }

    /**
     * 更新记录数(n)为判断条件
     * 结果 true：n>0,更新成功
     *      false: n=0,更新失败
     */
    @Test
    public void updateById() {
        User user = new User();
        user.setId(9L);
        user.setName("999_666_888");

        boolean n = userService.updateById(user);
        System.out.println(n);
    }

    /**
     * 不是根据更新数量来判断成功与否
     * 返回 true: 操作成功
     *      false: 操作失败
     */
    @Test
    public void updateBatchById() {
        List<User> list = Lists.newArrayList();
        User user;
        for (int i = 20000; i < 20010; i++) {
            user = new User();
            user.setId((long) i);
            user.setName(i + "_name_u0");
            list.add(user);
        }
        // 默认批量1000
        boolean b = userService.updateBatchById(list);
        System.out.println(b);
    }

}
